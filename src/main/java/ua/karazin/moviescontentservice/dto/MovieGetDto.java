package ua.karazin.moviescontentservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieGetDto {
    String uuid;
    String title;
    Integer releaseYear;
}
