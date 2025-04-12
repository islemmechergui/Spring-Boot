package com.fsegt.ds1springboot.repositories;

import com.fsegt.ds1springboot.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long>  {
}
