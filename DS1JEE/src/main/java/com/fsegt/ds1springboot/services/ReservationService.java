package com.fsegt.ds1springboot.services;

import com.fsegt.ds1springboot.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation creerReservation(Reservation Reservation);

    Reservation getReservationtById(String id);

    List<Reservation> getAllReservations();

    Reservation mettreAJourReservation(String id, Reservation Reservation);

    void supprimerReservation(String id);
}
