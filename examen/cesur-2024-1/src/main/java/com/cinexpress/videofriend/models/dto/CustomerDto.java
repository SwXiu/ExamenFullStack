package com.cinexpress.videofriend.models.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    @NotNull(message = "Se debe agregar un nombre")
    private String name;
    private String type;
    private List<String> preferences;
    private String subscription;
    private Long companyId;
    private List<Long> movieIds;
    private Long premiumSubscriptionId;
}
