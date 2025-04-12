package com.fsegt.ds1springboot.controllers;

import com.fsegt.ds1springboot.entities.Foyer;
import com.fsegt.ds1springboot.services.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foyers")
public class FoyerController {

    private final FoyerService foyerService;
    @Autowired
    public FoyerController(FoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable Long id) {
        Foyer foyer = foyerService.getFoyertById(id);
        return foyer != null ? ResponseEntity.ok(foyer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.creerFoyer(foyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable Long id, @RequestBody Foyer updatedFoyer) {
        Foyer foyer = foyerService.mettreAJourFoyer(id, updatedFoyer);
        return foyer != null ? ResponseEntity.ok(foyer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoyer(@PathVariable Long id) {
        foyerService.supprimerFoyer(id);
        return ResponseEntity.noContent().build();
    }
}

