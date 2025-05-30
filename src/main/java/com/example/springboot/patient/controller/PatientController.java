package com.example.springboot.patient.controller;


import com.example.springboot.patient.DTO.PatientDTO;
import com.example.springboot.patient.model.PatientModel;
import com.example.springboot.patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/patients")
    public ResponseEntity<PatientModel> savepatient(@RequestBody @Valid PatientDTO patientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.save(patientDTO));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientModel>> getAllpatients() {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.listAll());
    }

    @GetMapping("/patients/{cdPatient}")
    public ResponseEntity<Object> getOnepatient(@PathVariable(value="cdPatient") Long cdPatient) {
        PatientModel patient = patientService.findById(cdPatient);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @PutMapping("/patients/{cdPatient}")
    public ResponseEntity<Object> updatepatient(@PathVariable(value="cdPatient") long cdPatient,
                                               @RequestBody @Valid PatientDTO patientDTO) {
        PatientModel patient = patientService.findById(cdPatient);
        BeanUtils.copyProperties(patientDTO, patient);
        return ResponseEntity.status(HttpStatus.OK).body(patientService.update(patient));
    }

    @DeleteMapping("/patients/{cdPatient}")
    public ResponseEntity<Object> deletepatient(@PathVariable(value="cdPatient") long cdPatient) {
        PatientModel patient = patientService.findById(cdPatient);
        patientService.delete(patient);
        return ResponseEntity.status(HttpStatus.OK).body("patient deletado com sucesso");
    }
}
