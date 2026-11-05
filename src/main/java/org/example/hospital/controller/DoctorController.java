package org.example.hospital.controller;
import org.example.hospital.model.Doctor;
import org.example.hospital.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping
    public String listDoctors(Model model){
        model.addAttribute("doctors", doctorService.findAll());
        return "doctor/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("doctor", new Doctor());
        return "doctor/form";
    }

    @PostMapping
    public String createDoctor(@ModelAttribute("doctor") Doctor doctor){
        doctorService.save(doctor);
        return "redirect:/doctor";
    }

    @PostMapping("/{id}/delete")
    public String deleteDoctor(@PathVariable("id") String id){
        doctorService.deleteByID(id);
        return "redirect:/doctor";
    }
}
