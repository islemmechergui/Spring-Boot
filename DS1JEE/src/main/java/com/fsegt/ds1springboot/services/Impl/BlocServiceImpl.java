package com.fsegt.ds1springboot.services.Impl;

import com.fsegt.ds1springboot.entities.Bloc;
import com.fsegt.ds1springboot.repositories.BlocRepository;
import com.fsegt.ds1springboot.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements BlocService {
    private final BlocRepository blocRepository;

    @Autowired
    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Override
    public Bloc creerBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBloctById(Long id) {
        return blocRepository.findById(id).get();
    }


    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc mettreAJourBloc(Long id, Bloc updatedBloc) {
         Bloc bloc = getBloctById(id);
        bloc.setNomBloc(updatedBloc.getNomBloc());
        bloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());

        return blocRepository.save(bloc);
    }

    @Override
    public void supprimerBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }
}
