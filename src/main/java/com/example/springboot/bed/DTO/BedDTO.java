package com.example.springboot.bed.DTO;

import jakarta.validation.constraints.NotBlank;

public record BedDTO(@NotBlank int cdStatus, @NotBlank Long cdRoom, @NotBlank String deCodigo,Long cdPatient) {
}
