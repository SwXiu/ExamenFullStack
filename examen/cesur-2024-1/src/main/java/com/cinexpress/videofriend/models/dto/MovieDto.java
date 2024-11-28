package com.cinexpress.videofriend.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Long id;
    @NotNull(message = "Se debe agregar un nombre")
    private String title;
    private String format;
    private String genre;
    private String language;
    private Boolean availability;

    private Long inventoryId;
    private Long companyId;
    private Long customerId;
}
