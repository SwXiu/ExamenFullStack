package com.cinexpress.videofriend.services;

import java.util.List;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

public interface CustomerService {
    void createCustomer(Customer customer);
    void addClientToCompany(Long customerId, Long companyId);
    void addMovieToCustomer(Long movieId, Long customerId);
    List<Movie> listAllCustomerMovies(Long customerId); //He cambiado que sea por Id
    boolean hasPremiumSubscription(Long customerId);
    //void deactivatePremiumSubscription(Long customerId); He cambiado esta función para que pueda desactivar o activar
    void changePremiumSubscription(Long customerId);
}
