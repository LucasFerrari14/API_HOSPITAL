package com.example.springboot.room.DTO;

import jakarta.validation.constraints.NotBlank;

public record RoomDTO(@NotBlank String deCodigo, @NotBlank int cdStatus,@NotBlank Long cdHWing) {
}
