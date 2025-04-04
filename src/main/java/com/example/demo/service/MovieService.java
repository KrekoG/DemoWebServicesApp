package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

   private final MovieRepository movieRepository;

   public MovieService(MovieRepository movieRepository) {
      this.movieRepository = movieRepository;
   }

   public List<Movie> findAll() {
      return movieRepository.findAll();
   }

   public Movie create(Movie movie) {
      return movieRepository.save(movie);
   }

   public Movie read(Long id) {
      return movieRepository.findById(id).orElseThrow(
              () -> new ResourceNotFoundException(
                      String.format("Movie not found by %s", id)
              )
      );
   }

   public Movie update(Long id, Movie newMovie) {
      ensureResourceExists(id);
      newMovie.setId(id);
      return movieRepository.save(newMovie);
   }

   public void delete(Long id) {
      movieRepository.deleteById(id);
   }

   private void ensureResourceExists(Long id) {
      read(id);
   }

}
