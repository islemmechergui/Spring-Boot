package com.fsegt.ds1springboot.services;

import com.fsegt.ds1springboot.entities.Universite;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UniversiteService {
    Universite creerUniversite(Universite Universite);

    Universite getUniversitetById(Long id);

    List<Universite> getAllUniversites();

    Universite mettreAJourUniversite(Long id, Universite Universite);

    void supprimerUniversite(Long id);
}
