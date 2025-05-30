package com.example.springboot.hospitalizationslog.DTO;

import jakarta.validation.constraints.NotBlank;

public record HospitalizationsLogDTO(@NotBlank Long cdHWing, @NotBlank Long cdPatient) {
}
