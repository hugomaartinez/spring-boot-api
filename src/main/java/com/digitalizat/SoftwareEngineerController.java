package com.digitalizat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    // GET /api/v1/software-engineers
    @GetMapping
    public List<SoftwareEngineer> getAll() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    // GET /api/v1/software-engineers/{id}
    @GetMapping("/{id}")
    public SoftwareEngineer getById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    // POST /api/v1/software-engineers
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.createSoftwareEngineer(softwareEngineer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT /api/v1/software-engineers
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineer(softwareEngineer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE /api/v1/software-engineers/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
