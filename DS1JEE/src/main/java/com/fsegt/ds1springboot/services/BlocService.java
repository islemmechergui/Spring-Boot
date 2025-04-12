package com.fsegt.ds1springboot.services;


import com.fsegt.ds1springboot.entities.Bloc;

import java.util.List;


public interface BlocService {
    Bloc creerBloc(Bloc bloc);

    Bloc getBloctById(Long id);

    List<Bloc> getAllBlocs();

    Bloc mettreAJourBloc(Long id, Bloc bloc);

    void supprimerBloc(Long id);
}
