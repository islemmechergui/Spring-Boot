package com.fsegt.ds1springboot.controllers;
import com.fsegt.ds1springboot.entities.Etudiant;
import com.fsegt.ds1springboot.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    //  Créer un étudiant
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant nouveau = etudiantService.creerEtudiant(etudiant);
        return ResponseEntity.ok(nouveau);
    }

    //  Récupérer un étudiant par ID
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiant(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiant);
    }

    //  Récupérer tous les étudiants
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> liste = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(liste);
    }

    //  Mettre à jour un étudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant updated = etudiantService.mettreAJourEtudiant(id, etudiant);
        return ResponseEntity.ok(updated);
    }

    //  Supprimer un étudiant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}
