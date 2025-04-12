package com.fsegt.ds1springboot.services;

import com.fsegt.ds1springboot.entities.Foyer;

import java.util.List;

public interface FoyerService {
    Foyer creerFoyer(Foyer Foyer);

    Foyer getFoyertById(Long id);

    List<Foyer> getAllFoyers();

    Foyer mettreAJourFoyer(Long id, Foyer Foyer);

    void supprimerFoyer(Long id);
}
