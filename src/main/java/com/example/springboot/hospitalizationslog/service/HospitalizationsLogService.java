package com.example.springboot.hospitalizationslog.service;

import com.example.springboot.hospitalizationslog.DTO.HospitalizationsLogDTO;
import com.example.springboot.hospitalizationslog.model.HospitalizationsLogModel;
import com.example.springboot.hospitalizationslog.repository.HospitalizationsLogRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HospitalizationsLogService {

    @Autowired
    private HospitalizationsLogRepository hospitalRepository;

    public HospitalizationsLogModel findById(long id) {
        return hospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("Hospital não encontrado"));
    }
    public List<HospitalizationsLogModel> listAll() {
        return hospitalRepository.findAll();
    }

    public HospitalizationsLogModel save(@RequestBody @Valid HospitalizationsLogDTO hospitalDTO) {
        HospitalizationsLogModel hospital = new HospitalizationsLogModel();
        BeanUtils.copyProperties(hospitalDTO, hospital);
        hospitalRepository.save(hospital);
        return hospital;
    }

    public HospitalizationsLogModel update(@NotNull HospitalizationsLogModel hospital) {
        return hospitalRepository.save(hospital);
    }

    public void delete(@NotNull HospitalizationsLogModel hospital) {
        hospitalRepository.delete(hospital);
    }
}
