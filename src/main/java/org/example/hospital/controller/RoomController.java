package org.example.hospital.controller;

import org.example.hospital.model.Room;
import org.example.hospital.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.findAll());
        return "room/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/form";
    }

    @PostMapping
    public String createRoom(@ModelAttribute("room") Room room) {
        roomService.save(room);
        return "redirect:/room";
    }

    @PostMapping("/{id}/delete")
    public String deleteRoom(@PathVariable("id") String id) {
        roomService.deleteByID(id);
        return "redirect:/room";
    }
}
