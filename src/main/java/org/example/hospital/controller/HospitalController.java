package org.example.hospital.controller;
import org.example.hospital.model.Hospital;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class HospitalController {
    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService){
        this.hospitalService = hospitalService;
    }

    @GetMapping("/hospitals")
    @ResponseBody
    public List<Hospital> getAllHospitals(){
        return hospitalService.getAllHospitals();
    }
}
