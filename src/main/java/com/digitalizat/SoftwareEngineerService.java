package com.digitalizat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    // Gets all Software Engineers from the database
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    // Retrieves a Software Engineer by ID, throws an exception if not found
    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
            .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.NOT_FOUND,
                "Software Engineer with ID " + id + " does not exist."
            ));
    }

    // Adds a new Software Engineer to the database
    public void addSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    // Deletes a Software Engineer from the database
    public void deleteSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.delete(softwareEngineer);
    }

    // Updates an existing Software Engineer in the database
    public void updateSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        if (softwareEngineerRepository.existsById(softwareEngineer.getId())) {
            softwareEngineerRepository.save(softwareEngineer);
        } else {
            throw new IllegalArgumentException("Software Engineer with ID " + softwareEngineer.getId() + " does not exist.");
        }
    }
}
