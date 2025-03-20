package ua.karazin.moviescontentservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record MovieDto(UUID id,
                       @NotBlank String title,
                       @NotNull @Min(1800) Integer releaseYear) {
}
