package com.fsegt.ds1springboot.services.Impl;

import com.fsegt.ds1springboot.entities.Etudiant;
import com.fsegt.ds1springboot.repositories.EtudiantRepository;
import com.fsegt.ds1springboot.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant creerEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé avec l'ID : " + id));
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant mettreAJourEtudiant(Long id, Etudiant updatedEtudiant) {
        Etudiant etudiant = getEtudiantById(id);
        etudiant.setNomEt(updatedEtudiant.getNomEt());
        etudiant.setPrenomEt(updatedEtudiant.getPrenomEt());
        etudiant.setEcole(updatedEtudiant.getEcole());
        etudiant.setCin(updatedEtudiant.getCin());
        etudiant.setDateNaissance(updatedEtudiant.getDateNaissance());

        return etudiantRepository.save(etudiant);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}
