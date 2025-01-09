package ua.karazin.moviescontentservice.mapper;

import org.springframework.lang.NonNull;
import ua.karazin.moviescontentservice.dto.MovieChangeDto;
import ua.karazin.moviescontentservice.dto.MovieGetDto;
import ua.karazin.moviescontentservice.model.Movie;

public class MovieMapper {
    public static MovieGetDto toGetDto(Movie movie) {
        if (movie == null) {
            return null;
        }

        return MovieGetDto.builder()
                .uuid(movie.getUuid().toString())
                .title(movie.getTitle())
                .build();
    }

    public static Movie toMovie(MovieChangeDto dto) {
        return Movie.builder()
                .title(dto.getTitle())
                .build();
    }

    public static Movie toMovie(Movie original, MovieChangeDto dto) {
        var updated = toMovie(dto);
        updated.setUuid(original.getUuid());
        return updated;
    }

    public static MovieChangeDto toChangeDto(@NonNull MovieGetDto getDto) {
        return MovieChangeDto.builder()
                .title(getDto.getTitle())
                .build();
    }
}
