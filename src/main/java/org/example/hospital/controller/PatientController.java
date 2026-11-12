package org.example.hospital.controller;
import org.example.hospital.model.Patient;
import org.example.hospital.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping
    public String listPatients(Model model){
        model.addAttribute("patients", patientService.findAll());
        return "patient/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("patient", new Patient());
        return "patient/form";
    }

    @PostMapping
    public String createPatient(@ModelAttribute("patient") Patient patient){
        patientService.save(patient);
        return "redirect:/patient";
    }

    @GetMapping("/{id}")
    public String showDetails(@PathVariable("id") String id, Model model){
        model.addAttribute("patient", patientService.findById(id));
        return "patient/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") String id, Model model){
        model.addAttribute("patient", patientService.findById(id));
        return "patient/edit";
    }

    @PostMapping("/{id}/edit")
    public String updatePatient(@PathVariable("id") String id, @ModelAttribute("patient") Patient patient){
        patient.setId(id);
        patientService.update(patient);
        return "redirect:/patient";
    }

    @PostMapping("/{id}/delete")
    public String deletePatient(@PathVariable("id") String id){
        patientService.deleteById(id);
        return "redirect:/patient";
    }
}
