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
        model.addAttribute("hospital", new Hospital());
        return "hospital/form";
    }

    @PostMapping
    public String createHospital(@ModelAttribute("hospital") Hospital hospital) {
        hospitalService.save(hospital);
        return "redirect:/hospital";
    }

    @GetMapping("/{id}")
    public String showDetails(@PathVariable("id") String id, Model model) {
        model.addAttribute("hospital", hospitalService.findByID(id));
        return "hospital/details";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("hospital", hospitalService.findByID(id));
        return "hospital/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateHospital(@PathVariable("id") String id, @ModelAttribute("hospital") Hospital hospital) {
        hospital.setId(id);
        hospitalService.update(hospital);
        return "redirect:/hospital";
    }

    @PostMapping("/{id}/delete")
    public String deleteHospital(@PathVariable("id") String id) {
        hospitalService.deleteById(id);
        return "redirect:/hospital";
    }
}