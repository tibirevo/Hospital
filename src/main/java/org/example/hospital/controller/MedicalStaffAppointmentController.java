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
    public String listAll(Model model) {
        model.addAttribute("medicalStaffAppointments", medicalStaffAppointmentService.findAll());
        return "medicalstaffappointment/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("medicalStaffAppointment", new MedicalStaffAppointment());
        return "medicalstaffappointment/form";
    }

    @PostMapping
    public String create(@ModelAttribute("medicalStaffAppointment") MedicalStaffAppointment item) {
        medicalStaffAppointmentService.save(item);
        return "redirect:/medicalstaffappointment";
    }

    @GetMapping("/{id}")
    public String showDetails(@PathVariable("id") String id, Model model) {
        model.addAttribute("medicalStaffAppointment", medicalStaffAppointmentService.findById(id));
        return "medicalStaffAppointment/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("medicalStaffAppointment", medicalStaffAppointmentService.findById(id));
        return "medicalStaffAppointment/edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") String id, @ModelAttribute("medicalStaffAppointment") MedicalStaffAppointment medicalStaffAppointment) {
        medicalStaffAppointment.setId(id);
        medicalStaffAppointmentService.update(medicalStaffAppointment);
        return "redirect:/medicalStaffAppointment";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id) {
        medicalStaffAppointmentService.deleteById(id);
        return "redirect:/medicalstaffappointment";
    }
}
