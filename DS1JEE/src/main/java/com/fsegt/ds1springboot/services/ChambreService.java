package com.fsegt.ds1springboot.services;

import com.fsegt.ds1springboot.entities.Chambre;

import java.util.List;

public interface ChambreService {
    Chambre creerChambre(Chambre Chambre);

    Chambre getChambretById(Long id);

    List<Chambre> getAllChambres();

    Chambre mettreAJourChambre(Long id, Chambre Chambre);

    void supprimerChambre(Long id);
}
