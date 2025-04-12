package com.fsegt.ds1springboot.controllers;


import com.fsegt.ds1springboot.entities.Universite;
import com.fsegt.ds1springboot.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversitetById(id);
    }

    @PostMapping
    public Universite createUniversite(@RequestBody Universite universite) {
        return universiteService.creerUniversite(universite);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        return universiteService.mettreAJourUniversite(id, universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.supprimerUniversite(id);
    }
}
