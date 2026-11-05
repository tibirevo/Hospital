package org.example.hospital.controller;

import org.example.hospital.model.Nurse;
import org.example.hospital.service.NurseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nurse")
public class NurseController {

    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping
    public String listNurses(Model model) {
        model.addAttribute("nurses", nurseService.findAll());
        return "nurse/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("nurse", new Nurse());
        return "nurse/form";
    }

    @PostMapping
    public String createNurse(@ModelAttribute("nurse") Nurse nurse) {
        nurseService.save(nurse);
        return "redirect:/nurse";
    }

    @PostMapping("/{id}/delete")
    public String deleteNurse(@PathVariable("id") String id) {
        nurseService.deleteByID(id);
        return "redirect:/nurse";
    }
}
