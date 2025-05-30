package com.example.springboot.hwing.controller;


import com.example.springboot.hwing.DTO.HWingDTO;
import com.example.springboot.hwing.model.HWingModel;
import com.example.springboot.hwing.service.HWingService;
import com.example.springboot.room.DTO.RoomDTO;
import com.example.springboot.room.controller.RoomController;
import com.example.springboot.room.model.RoomModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HWingController {
    @Autowired
    private HWingService hwingService;

    @PostMapping("/hwings")
    public ResponseEntity<HWingModel> savehwing(@RequestBody @Valid HWingDTO hwingDTO, @NotBlank int nuRoom, @NotNull int nuBed) {
        HWingModel wing = hwingService.save(hwingDTO);
        generateRoom(nuRoom, wing, nuBed);
        return ResponseEntity.status(HttpStatus.CREATED).body(wing);
    }

    @GetMapping("/hwings")
    public ResponseEntity<List<HWingModel>> getAllhwings() {
        return ResponseEntity.status(HttpStatus.OK).body(hwingService.listAll());
    }

    @GetMapping("/hwings/{cdHWing}")
    public ResponseEntity<Object> getOnehwing(@PathVariable(value="cdHWing") Long cdHWing) {
        HWingModel hwing = hwingService.findById(cdHWing);
        return ResponseEntity.status(HttpStatus.OK).body(hwing);
    }

    @PutMapping("/hwings/{cdHWing}")
    public ResponseEntity<Object> updatehwing(@PathVariable(value="cdHWing") long cdHWing,
                                               @RequestBody @Valid HWingDTO hwingDTO) {
        HWingModel hwing = hwingService.findById(cdHWing);
        BeanUtils.copyProperties(hwingDTO, hwing);
        return ResponseEntity.status(HttpStatus.OK).body(hwingService.update(hwing));
    }

    @DeleteMapping("/hwings/{cdHWing}")
    public ResponseEntity<Object> deletehwing(@PathVariable(value="cdHWing") long cdHWing) {
        HWingModel hwing = hwingService.findById(cdHWing);
        hwingService.delete(hwing);
        return ResponseEntity.status(HttpStatus.OK).body("hwing deletado com sucesso");
    }

    public void generateRoom(int nuRoom, HWingModel wing, int nuBed) {
        RoomController roomController = new RoomController();
        for (int i = 1; i <= nuRoom; i++) {
            RoomDTO room = new RoomDTO(wing.getDeSpecialty().getDeName().substring(0,3) + i,
                    0, wing.getCdHWing());
            roomController.saveRoom(room, nuBed);
        }
    }
}
