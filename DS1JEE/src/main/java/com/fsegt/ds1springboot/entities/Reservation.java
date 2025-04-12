package com.fsegt.ds1springboot.entities;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Data;
@Data
@Entity

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;



    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;
    @ManyToMany(mappedBy = "reservations", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

}
