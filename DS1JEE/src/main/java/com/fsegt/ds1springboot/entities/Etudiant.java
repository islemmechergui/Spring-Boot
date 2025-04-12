package com.fsegt.ds1springboot.entities;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import lombok.Data;
@Data
@Entity

public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;


    @Temporal(TemporalType.DATE)
    private Date dateNaissance;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_id")
    )
    private List<Reservation> reservations;


}
