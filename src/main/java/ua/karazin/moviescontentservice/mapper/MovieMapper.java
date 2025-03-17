package ua.karazin.moviescontentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.model.Movie;

@Mapper
public interface MovieMapper {
    @Mapping(source = "uuid", target = "uuid")
    MovieGetDto toGetDto(Movie movie);
    Movie toMovie(MovieChangeDto dto);
}
