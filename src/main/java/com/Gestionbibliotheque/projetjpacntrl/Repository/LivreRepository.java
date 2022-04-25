package com.Gestionbibliotheque.projetjpacntrl.Repository;

import com.Gestionbibliotheque.projetjpacntrl.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LivreRepository extends JpaRepository<Livre,Integer> {



}
