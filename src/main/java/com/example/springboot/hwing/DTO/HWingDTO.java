package com.example.springboot.hwing.DTO;

import jakarta.validation.constraints.NotBlank;

public record HWingDTO(@NotBlank int specialtyCode, @NotBlank long cdHospital) {
}
