package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.repository.CustomerRepository;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.repository.PremiumSubscriptionRepository;
import com.cinexpress.videofriend.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PremiumSubscriptionRepository premiumSubscriptionRepository;

    @Override
    public void addClientToCompany(Long customerId, Long companyId) {
        Customer customer = customerRepository.findById(customerId).get();
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isEmpty()){
            Company updateCompany = company.get();
            updateCompany.getCustomers().add(customer);
            customer.setCompany(updateCompany);
            companyRepository.save(updateCompany);
            customerRepository.save(customer);
        }
    }

    @Override
    public void addMovieToCustomer(Long movieId, Long customerId) {
        Movie movie = movieRepository.findById(movieId).get();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(!customer.isEmpty()){
            Customer updateCustomer = customer.get();
            updateCustomer.getMovies().add(movie);
            movie.setCustomer(updateCustomer);
            customerRepository.save(updateCustomer);
            movieRepository.save(movie);
        }
    }

    @Override
    public List<Movie> listAllCustomerMovies(Long customerId) {
        return customerRepository.findMoviesByCustomerId(customerId).get();
    }

    @Override
    public boolean hasPremiumSubscription(Long customerId) {
        Customer customer = customerRepository.getReferenceById(customerId);
        return customer.getPremiumSubscription().getExclusiveCatalog();
    }

    //No tiene sentido porque tendriamos que hacer otra función para activar la suscripción
    // @Override
    // public void deactivatePremiumSubscription(Long customerId) {
    //     Optional<Customer> customer = customerRepository.findById(customerId);
    //     if(customer.isPresent()){
    //         Customer niCustomer = customer.get();
    //         PremiumSubscription premium = new PremiumSubscription();
    //         premium.setDiscounts(false);
    //         premium.setExclusiveCatalog(false);
    //         premium.setPreReleases(false);
    //         premium.setCustomer(niCustomer);
    //         premiumSubscriptionRepository.save(premium);
    //     }
        
    // }

    //Función para activar o desactivar premium
    @Override
    public void changePremiumSubscription(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()){
            if(hasPremiumSubscription(customerId)) {
                Customer niCustomer = customer.get();
                PremiumSubscription premium = new PremiumSubscription();
                premium.setDiscounts(false);
                premium.setExclusiveCatalog(false);
                premium.setPreReleases(false);
                premium.setCustomer(niCustomer);
                premiumSubscriptionRepository.save(premium);
            } else {
                Customer niCustomer = customer.get();
                PremiumSubscription premium = new PremiumSubscription();
                premium.setDiscounts(true);
                premium.setExclusiveCatalog(true);
                premium.setPreReleases(true);
                premium.setCustomer(niCustomer);
                premiumSubscriptionRepository.save(premium);
            }
        }
        
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    
}
