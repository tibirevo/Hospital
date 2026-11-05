package org.example.hospital.controller;

import org.example.hospital.model.Hospital;
import org.example.hospital.service.HospitalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    public String listHospitals(Model model) {
        model.addAttribute("hospitals", hospitalService.findAll());
        return "hospital/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("hospitals", new Hospital());
        return "hospital/form";
    }

    @PostMapping
    public String createHospital(@ModelAttribute("hospital") Hospital hospital) {
        hospitalService.save(hospital);
        return "redirect:/hospital";
    }

    @PostMapping("/{id}/delete")
    public String deleteHospital(@PathVariable("id") String id) {
        hospitalService.deleteByID(id);
        return "redirect:/hospital";
    }
}