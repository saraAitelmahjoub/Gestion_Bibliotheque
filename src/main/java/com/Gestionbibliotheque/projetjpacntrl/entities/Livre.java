package com.Gestionbibliotheque.projetjpacntrl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Livre")
@Data
@NoArgsConstructor
public class Livre {

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy(value = "ID ASC")
    private Integer ID;

    @Column(name = "Titre",nullable = false,length = 50)
    private String Titre;

    @Column(name = "Maison d'édition" , updatable = false,nullable = false)
    private String Maison_Edition;

    @Column(name = "Date de sortie",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date Date_Sortie;

    @Column(name = "Auteur",nullable = false)
    private String Auteur;

    @Column(name = "Nombre de page",nullable = false)
    private Integer Nombre_Page;

    @Column(name = "ISBN" ,unique = true, updatable = false,nullable = false)
    private String ISBN;

    @Column(name = "Date derniere consultation",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private  Date Date_Derniere_Consultation;

    @Column(name = "Disponibilité du livre",nullable = false)
    private boolean Disponible=true;

    //Les Constructeur
    public Livre(String titre,String auteur,String maison_Edition,Date date_Sortie,Integer nombre_Page,String ISBN,Date date_Derniere_Consultation,boolean disponible) {
        Nombre_Page = nombre_Page;
        Titre = titre;
        Maison_Edition = maison_Edition;
        Date_Sortie = date_Sortie;
        Auteur = auteur;
        Nombre_Page = nombre_Page;
        this.ISBN = ISBN;
        Disponible = disponible;
        Date_Derniere_Consultation = date_Derniere_Consultation;
    }





}
