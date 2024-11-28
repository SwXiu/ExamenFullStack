package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Movie;

public interface MovieService {
    void addMovie(Movie movie);
    void updateMovie(Movie move);
    void updateAvailability(Movie movie);
}
