package com.fsegt.ds1springboot.services.Impl;

import com.fsegt.ds1springboot.entities.Chambre;
import com.fsegt.ds1springboot.repositories.ChambreRepository;
import com.fsegt.ds1springboot.services.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {
    private final ChambreRepository chambreRepository;

    @Autowired
    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre creerChambre(Chambre Chambre) {
        return chambreRepository.save(Chambre);
    }

    @Override
    public Chambre getChambretById(Long id) {
        return chambreRepository.findById(id).get();
    }


    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre mettreAJourChambre(Long id, Chambre updatedChambre) {
        Chambre chambre = getChambretById(id);
        chambre.setNumeroChambre(updatedChambre.getNumeroChambre());
        return chambreRepository.save(chambre);
    }

    @Override
    public void supprimerChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}

