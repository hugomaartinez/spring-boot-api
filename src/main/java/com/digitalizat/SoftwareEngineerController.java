package com.digitalizat;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService SoftwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.SoftwareEngineerService = softwareEngineerService;
    }

    // Get all software engineers
    @GetMapping()
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return SoftwareEngineerService.getAllSoftwareEngineers();
    }

    // Get a software engineer by ID
    @GetMapping("/{id}")
    public SoftwareEngineer getSoftwareEngineerById(@PathVariable Integer id) {
        return SoftwareEngineerService.getSoftwareEngineerById(id);
    }

    // Add a new software engineer
    @PostMapping()
    public void addSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
         SoftwareEngineerService.addSoftwareEngineer(softwareEngineer);
    }

    // Delete a software engineer
    @DeleteMapping()
    public void deleteSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        SoftwareEngineerService.deleteSoftwareEngineer(softwareEngineer);
    }

    // Update an existing software engineer
    @PutMapping()
    public void updateSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        SoftwareEngineerService.updateSoftwareEngineer(softwareEngineer);
    }
}
