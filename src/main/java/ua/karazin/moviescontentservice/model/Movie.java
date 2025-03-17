package ua.karazin.moviescontentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Entity
@Table(name = "movies")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @NotBlank
    @Size(min = 1, max = 500)
    private String title;

//    @Size(max = 300)
//    private String summary;
//
//    @Min(1)
//    @Max(1440)
//    private Integer durationMinutes;

    @NotNull
    @Min(1800)
    private Integer releaseYear;

//    @URL
//    private String trailerUrl;
}
