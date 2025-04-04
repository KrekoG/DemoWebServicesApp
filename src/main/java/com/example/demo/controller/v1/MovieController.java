package com.example.demo.controller.v1;

import com.example.demo.entity.Movie;
import com.example.demo.entity.dto.MovieDto;
import com.example.demo.entity.mapper.MovieMapper;
import com.example.demo.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieDto> allMovies() {
        return movieService.findAll().stream().map(this::toDto).toList();
    }

    @PostMapping("/")
    public MovieDto createMovie(
            @RequestBody MovieDto movieDto,
            BindingResult bindingResult
    ) {
        return toDto(movieService.create(fromDto(movieDto)));
    }

    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable Long id) {
        return toDto(movieService.read(id));
    }

    @PutMapping("/{id}")
    public MovieDto updateMovie(
            @PathVariable Long id,
            @RequestBody MovieDto movieDto
    ) {
        return toDto(movieService.update(
                id,
                fromDto(movieDto)
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Movie fromDto(MovieDto movieDto) {
        return MovieMapper.INSTANCE.toMovie(movieDto);
    }

    private MovieDto toDto(Movie movie) {
        return MovieMapper.INSTANCE.toMovieDto(movie);
    }

}
