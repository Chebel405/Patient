package com.example.demo.Controller;

import com.example.demo.Dto.PatientDTO;
import com.example.demo.Entity.Patient;
import com.example.demo.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){

        this.patientService = patientService;
    }
    @GetMapping
    public List<PatientDTO> findAll(){
        return patientService.findAll();}

    @GetMapping("/{id}")
    public Optional<PatientDTO> findById(@PathVariable Long id){
        return patientService.findById(id);}

    @PostMapping("")
    public PatientDTO createPatient(@RequestBody PatientDTO patientDTO){
        return patientService.createPatient(patientDTO);
    }

    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO){
        return patientService.updatePatient(id, patientDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
    }
}