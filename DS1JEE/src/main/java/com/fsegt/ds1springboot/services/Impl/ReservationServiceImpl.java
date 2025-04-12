package com.fsegt.ds1springboot.services.Impl;

import com.fsegt.ds1springboot.entities.Reservation;
import com.fsegt.ds1springboot.repositories.ReservationRepository;
import com.fsegt.ds1springboot.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Reservation creerReservation(Reservation Reservation) {
        return reservationRepository.save(Reservation);
    }

    @Override
    public Reservation getReservationtById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation mettreAJourReservation(String id, Reservation reservation) {
        Reservation reservationEntity = getReservationtById(id);
        reservationEntity.setAnneeUniversitaire(reservation.getAnneeUniversitaire());
        reservationEntity.setEstValide(reservation.isEstValide());
        return reservationRepository.save(reservationEntity);
    }

    @Override
    public void supprimerReservation(String id) {
        reservationRepository.deleteById(id);
    }
}
