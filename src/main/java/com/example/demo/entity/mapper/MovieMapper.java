package com.example.demo.entity.mapper;

import com.example.demo.entity.Movie;
import com.example.demo.entity.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

   MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

   Movie toMovie(MovieDto movieDto);

   MovieDto toMovieDto(Movie movie);

}
