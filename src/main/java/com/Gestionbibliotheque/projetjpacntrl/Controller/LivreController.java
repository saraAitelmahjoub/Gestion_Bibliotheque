package com.Gestionbibliotheque.projetjpacntrl.Controller;

import com.Gestionbibliotheque.projetjpacntrl.Repository.LivreRepository;
import com.Gestionbibliotheque.projetjpacntrl.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreController {
    @Autowired LivreRepository livreRepository;

    @GetMapping("/bibliotheque/livre")
    List<Livre> SlectLivres() {
        return livreRepository.findAll();

    }
    @GetMapping("/bibliotheque/livre/{id}")
    Livre unSeulLivre(@PathVariable Integer id) throws ClassNotFoundException {
        return livreRepository.findById(id)
                .orElseThrow(() -> new ClassNotFoundException() );
    }
    @DeleteMapping("/bibliotheque/livre/{id}")
    String deleteLivre(@PathVariable Integer id) {
        livreRepository.deleteById(id);
        return"livre deleted";
    }
    @PutMapping("/bibliotheque/livre/{id}")
    Livre ModifierLivre(@RequestBody Livre newLivre, @PathVariable Integer id) {
        return livreRepository.findById(id)
                .map(livre -> {
                    livre.setTitre(newLivre.getTitre());
                    livre.setAuteur(newLivre.getAuteur());
                    livre.setNombre_Page(newLivre.getNombre_Page());
                    livre.setDate_Sortie(newLivre.getDate_Sortie());
                    livre.setDate_Derniere_Consultation(newLivre.getDate_Derniere_Consultation());
                    return livreRepository.save(livre);
                })
                .orElseGet(() -> {
                    newLivre.setID(id);
                    return livreRepository.save(newLivre);
                });
    }
    @PostMapping("/bibliotheque/livre")
    Livre nvLivre(@RequestBody Livre nvLivre){
        return  livreRepository.save(nvLivre);
    }


}

