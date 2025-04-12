package com.fsegt.ds1springboot.services;



import com.fsegt.ds1springboot.entities.Etudiant;

import java.util.List;

public interface EtudiantService {

    Etudiant creerEtudiant(Etudiant etudiant);

    Etudiant getEtudiantById(Long id);

    List<Etudiant> getAllEtudiants();

    Etudiant mettreAJourEtudiant(Long id, Etudiant etudiant);

    void supprimerEtudiant(Long id);
}
