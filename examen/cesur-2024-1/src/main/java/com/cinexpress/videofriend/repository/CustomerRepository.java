package com.cinexpress.videofriend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT movies FROM Customer i WHERE i.id = :customerId")
    Optional<List<Movie>> findMoviesByCustomerId(@Param("customerId") Long customerId);
}
