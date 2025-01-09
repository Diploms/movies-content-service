package ua.karazin.moviescontentservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieGetDto {
    String uuid;
    String title;
    String summary;
    Integer durationMinutes;
    Integer releaseYear;
    String trailerUrl;
}
