package org.example.hospital.controller;
import org.example.hospital.model.Department;
import org.example.hospital.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public String listDepartment(Model model){
        model.addAttribute("departments", departmentService.findAll());
        return "department/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("department", new Department());
        return "department/form";
    }

    @PostMapping
    public String createDepartment(@ModelAttribute("department") Department department){
        departmentService.save(department);
        return "redirect:/department";
    }

    @GetMapping("/{id}")
    public String showDetails(@PathVariable("id") String id, Model model) {
        model.addAttribute("department", departmentService.findById(id));
        return "department/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("department", departmentService.findById(id));
        return "department/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateDepartment(@PathVariable("id") String id, @ModelAttribute("department") Department department){
        department.setId(id);
        departmentService.update(department);
        return "redirect:/department";
    }

    @PostMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable("id") String id){
        departmentService.deleteById(id);
        return "redirect:/department";
    }
}
