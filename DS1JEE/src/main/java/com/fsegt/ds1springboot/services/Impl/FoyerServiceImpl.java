package com.fsegt.ds1springboot.services.Impl;

import com.fsegt.ds1springboot.entities.Foyer;
import com.fsegt.ds1springboot.repositories.FoyerRepository;
import com.fsegt.ds1springboot.services.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements FoyerService {

    private final FoyerRepository foyerRepository;

    @Autowired
    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }
    @Override
    public Foyer creerFoyer(Foyer Foyer) {
        return foyerRepository.save(Foyer);
    }

    @Override
    public Foyer getFoyertById(Long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer mettreAJourFoyer(Long id, Foyer foyer) {

        Foyer foyerEntity = getFoyertById(id);
        foyerEntity.setNomFoyer(foyer.getNomFoyer());
        foyerEntity.setCapaciteFoyer(foyer.getCapaciteFoyer());
        return foyerRepository.save(foyerEntity);

    }

    @Override
    public void supprimerFoyer(Long id) {
        foyerRepository.deleteById(id);

    }
}
