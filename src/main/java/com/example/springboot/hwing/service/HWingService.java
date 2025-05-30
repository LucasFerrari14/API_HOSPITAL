package com.example.springboot.hwing.service;

import com.example.springboot.hwing.DTO.HWingDTO;
import com.example.springboot.hwing.model.HWingModel;
import com.example.springboot.hwing.repository.HWingRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HWingService {

    @Autowired
    private HWingRepository hwingRepository;

    public HWingModel findById(long id) {
        return hwingRepository.findById(id).orElseThrow(() -> new RuntimeException("hWing não encontrado"));
    }
    public List<HWingModel> listAll() {
        return hwingRepository.findAll();
    }

    public HWingModel save(@RequestBody @Valid HWingDTO hwingDTO) {
        HWingModel hwing = new HWingModel();
        BeanUtils.copyProperties(hwingDTO, hwing);
        hwingRepository.save(hwing);
        return hwing;
    }

    public HWingModel update(@NotNull HWingModel hwing) {
        return hwingRepository.save(hwing);
    }

    public void delete(@NotNull HWingModel hwing) {
        hwingRepository.delete(hwing);
    }
}
