package com.example.demo.service;

import com.example.demo.entity.Movie;
import com.example.demo.entity.dto.MovieDto;
import com.example.demo.entity.mapper.MovieMapper;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

   private final MovieRepository movieRepository;

   public MovieService(MovieRepository movieRepository) {
      this.movieRepository = movieRepository;
   }

   public List<Movie> findAll() {
      return movieRepository.findAll();
   }

   public MovieDto create(MovieDto movieDto) {
      Movie newMovie = movieRepository.save(MovieMapper.INSTANCE.toMovie(movieDto));

      return MovieMapper.INSTANCE.toMovieDto(newMovie);
   }

   public MovieDto read(Long id) {
      Optional<Movie> movie = movieRepository.findById(id);

      return movie.map(MovieMapper.INSTANCE::toMovieDto).orElse(null);
   }

   public MovieDto update(Long id, MovieDto movieDto) {
      movieRepository.findById(id).orElseThrow(
              () -> new ResourceNotFoundException(
                      String.format("Movie not found by %s", id)
              )
      );

      Movie newMovie = MovieMapper.INSTANCE.toMovie(movieDto);
      newMovie.setId(id);
      movieRepository.save(newMovie);
      return MovieMapper.INSTANCE.toMovieDto(newMovie);
   }

   public void delete(Long id) {
      movieRepository.deleteById(id);
   }

}
