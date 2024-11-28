package com.cinexpress.videofriend.models.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    @NotNull(message = "Se debe agregar un nombre")
    private String name;
    private String description;

    private List<Long> movieIds;
    private List<Long> customerIds;
}
