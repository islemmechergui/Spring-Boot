package com.fsegt.ds1springboot.entities;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;


    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;


}

enum TypeChambre {
    SIMPLE, DOUBLE, TRIPLE
}
