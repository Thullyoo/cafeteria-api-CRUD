package com.example.cafeteriaapi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCafe(

        String id,

        @NotBlank
        String nome,

        @NotNull
        Integer preco_in_cents,
        @NotNull
        Integer quantidade

        ) {
}
