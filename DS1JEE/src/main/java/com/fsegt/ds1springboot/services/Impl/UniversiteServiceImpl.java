package com.fsegt.ds1springboot.services.Impl;

import com.fsegt.ds1springboot.entities.Universite;
import com.fsegt.ds1springboot.repositories.UniversiteRepository;
import com.fsegt.ds1springboot.services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UniversiteServiceImpl implements UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    public UniversiteServiceImpl(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @Override
    public Universite creerUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }



    @Override
    public Universite getUniversitetById(Long id) {
        return universiteRepository.findById(id).get();
    }


    @Override
    public List<Universite> getAllUniversites(){
        return universiteRepository.findAll();
    }

    @Override
    public Universite mettreAJourUniversite(Long id, Universite updatedUniversite) {
        Universite universite = getUniversitetById(id);
        universite.setIdUniversite(updatedUniversite.getIdUniversite());
        universite.setNomUniversite(updatedUniversite.getNomUniversite());
        universite.setAdresse(updatedUniversite.getAdresse());


        return universiteRepository.save(universite);
    }

    @Override
    public void supprimerUniversite(Long idUniversite) {

        universiteRepository.deleteById(idUniversite);

    }
}


