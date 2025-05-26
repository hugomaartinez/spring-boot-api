package com.digitalizat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/software-engineers")
@RequiredArgsConstructor
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    @GetMapping
    public List<SoftwareEngineer> getAll() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.createSoftwareEngineer(softwareEngineer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineer(softwareEngineer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
        return ResponseEntity.noContent().build();
    }
}

