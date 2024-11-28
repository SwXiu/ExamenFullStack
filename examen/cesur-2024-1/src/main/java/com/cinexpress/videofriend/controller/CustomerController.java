package com.cinexpress.videofriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.repository.CustomerRepository;
import com.cinexpress.videofriend.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/company/{companyid}/customers/{customerId}")
    public ResponseEntity<Void> addCustomerToCompany(@PathVariable(name = "companyid") Long compaid, @PathVariable(name = "customerId") Long customid) {
        try {
            customerService.addClientToCompany(customid, compaid);
            return ResponseEntity.status(HttpStatus.OK).build();            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/{customerId}/movies/{movieId}")
    public ResponseEntity<Movie> addMovieCustomer(@PathVariable(name = "customerId") Long customid, @PathVariable(name = "customerId") Long movid) {
        try {
            customerService.addMovieToCustomer(movid, customid);
            return ResponseEntity.status(HttpStatus.OK).build();         
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{customerId}/movies")
    public ResponseEntity<List<Movie>> listAllCustomerMovies(@PathVariable(name = "customerId") Long id) {
            List<Movie> movies = customerService.listAllCustomerMovies(id);
        try {
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{customerId}/premium")
    public ResponseEntity<Boolean> hasPremiumSubscription(@PathVariable(name = "customerId") Long id) {
        boolean hasPremium = customerService.hasPremiumSubscription(id);
        try {
            return ResponseEntity.ok(hasPremium);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/{customerId}/premium")
    public ResponseEntity<Void> activatePremiumSubscription(@PathVariable(name = "customerId") Long id) {
        customerService.changePremiumSubscription(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
