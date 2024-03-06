package com.example.cafeteriaapi.DTO;

import jakarta.validation.constraints.NotBlank;

public record RequestCafeId (
        @NotBlank
        String id
){
}
