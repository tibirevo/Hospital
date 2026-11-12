package org.example.hospital.controller;
import org.example.hospital.model.Appointment;
import org.example.hospital.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public String listAppointments(Model model){
        model.addAttribute("appointments", appointmentService.findAll());
        return "appointment/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("appointment", new Appointment());
        return "appointment/form";
    }

    @PostMapping
    public String createAppointment(@ModelAttribute("appointment") Appointment appointment){
        appointmentService.save(appointment);
        return "redirect:/appointment";
    }

    @GetMapping("/{id}")
    public String showDetails(@PathVariable("id") String id, Model model) {
        model.addAttribute("appointment", appointmentService.findById(id));
        return "appointment/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("appointment", appointmentService.findById(id));
        return "appointment/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateAppointment(@PathVariable("id") String id, @ModelAttribute("appointment") Appointment appointment){
        appointment.setId(id);
        appointmentService.update(appointment);
        return "redirect:/appointment";
    }

    @PostMapping("/{id}/delete")
    public String deleteAppointment(@PathVariable("id") String id){
        appointmentService.deleteById(id);
        return "redirect:/appointment";
    }
}
