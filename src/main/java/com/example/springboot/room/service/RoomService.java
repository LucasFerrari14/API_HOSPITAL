package com.example.springboot.room.service;

import com.example.springboot.room.DTO.RoomDTO;
import com.example.springboot.room.model.RoomModel;
import com.example.springboot.room.repository.RoomRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomModel findById(long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room não encontrado"));
    }
    public List<RoomModel> listAll() {
        return roomRepository.findAll();
    }

    public RoomModel save(@RequestBody @Valid RoomDTO roomDTO) {
        RoomModel room = new RoomModel();
        BeanUtils.copyProperties(roomDTO, room);
        roomRepository.save(room);
        return room;
    }

    public RoomModel update(@NotNull RoomModel room) {
        return roomRepository.save(room);
    }

    public void delete(@NotNull RoomModel room) {
        roomRepository.delete(room);
    }
}
