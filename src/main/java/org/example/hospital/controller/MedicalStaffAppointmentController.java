package org.example.hospital.controller;

import org.example.hospital.model.MedicalStaffAppointment;
import org.example.hospital.service.MedicalStaffAppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medicalstaffappointment")
public class MedicalStaffAppointmentController {

    private final MedicalStaffAppointmentService medicalStaffAppointmentService;

    public MedicalStaffAppointmentController(MedicalStaffAppointmentService medicalStaffAppointmentService) {
        this.medicalStaffAppointmentService = medicalStaffAppointmentService;
    }

    @GetMapping
    public String listMedicalStaffAppointments(Model model) {
        model.addAttribute("medicalStaffAppointments", medicalStaffAppointmentService.findAll());
        return "medicalstaffappointment/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("medicalStaffAppointment", new MedicalStaffAppointment());
        return "medicalstaffappointment/form";
    }

    @PostMapping
    public String createMedicalStaffAppointment(@ModelAttribute("medicalStaffAppointment") MedicalStaffAppointment item) {
        medicalStaffAppointmentService.save(item);
        return "redirect:/medicalstaffappointment";
    }

    @PostMapping("/{id}/delete")
    public String deleteMedicalStaffAppointment(@PathVariable("id") String id) {
        medicalStaffAppointmentService.deleteByID(id);
        return "redirect:/medicalstaffappointment";
    }
}
