package com.example.springboot.bed.service;

import com.example.springboot.bed.DTO.BedDTO;
import com.example.springboot.bed.model.BedModel;
import com.example.springboot.bed.repository.BedRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    public BedModel findById(long id) {
        return bedRepository.findById(id).orElseThrow(() -> new RuntimeException("Bed não encontrado"));
    }
    public List<BedModel> listAll() {
        return bedRepository.findAll();
    }

    public BedModel save(@RequestBody @Valid BedDTO bedDTO) {
        BedModel bed = new BedModel();
        BeanUtils.copyProperties(bedDTO, bed);
        bedRepository.save(bed);
        return bed;
    }

    public BedModel update(@NotNull BedModel bed) {
        return bedRepository.save(bed);
    }

    public void delete(@NotNull BedModel bed) {
        bedRepository.delete(bed);
    }
}
