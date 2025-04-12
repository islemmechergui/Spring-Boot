package com.fsegt.ds1springboot.controllers;
import com.fsegt.ds1springboot.entities.Bloc;
import com.fsegt.ds1springboot.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    private final BlocService BlocService;

    @Autowired
    public BlocController(BlocService BlocService) {
        this.BlocService = BlocService;
    }



    @PostMapping
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc Bloc) {
        Bloc nouveau = BlocService.creerBloc(Bloc);
        return ResponseEntity.ok(nouveau);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBloc(@PathVariable Long id) {
        Bloc bloc = BlocService.getBloctById(id);
        return ResponseEntity.ok(bloc);
    }

    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> liste = BlocService.getAllBlocs();
        return ResponseEntity.ok(liste);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc Bloc) {
        Bloc updated = BlocService.mettreAJourBloc(id, Bloc);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        BlocService.supprimerBloc(id);
        return ResponseEntity.noContent().build();
    }
}
