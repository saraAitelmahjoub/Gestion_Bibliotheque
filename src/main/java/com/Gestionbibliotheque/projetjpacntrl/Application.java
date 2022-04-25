package com.Gestionbibliotheque.projetjpacntrl;

import com.Gestionbibliotheque.projetjpacntrl.Repository.LivreRepository;
import com.Gestionbibliotheque.projetjpacntrl.entities.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class Application implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired  private LivreRepository livreRepo;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("***********Bibiotheque *******");
		int userName=0;
		int NbPage=0;
		String Titre,Auteur,Maison_edt,Isbn;
		Boolean dispo=true;

		do {
			System.out.println("1*Ajoutez un nouveau livre");
			System.out.println("2*Afficher les livres");
			System.out.println("3*Supprimer un livre");
			System.out.println("4*Modifier les information sur un livre");
			Scanner myObj = new Scanner(System.in);
			userName = Integer.parseInt(myObj.nextLine());
		}while(userName==0);

		Scanner myObj = new Scanner(System.in);

		if(userName==1){
			Livre nvlivre;
			System.out.println("------  Ajouter des livres -------");
			System.out.print("Titre :");
			Titre = myObj.nextLine();
			System.out.println();
			System.out.print("Aurteur:");
			Auteur= myObj.nextLine();
			System.out.println();
			System.out.print("Maison d'edition:");
			Maison_edt= myObj.nextLine();
			System.out.println();
			System.out.print("Nombre de page :");
			NbPage= Integer.parseInt(myObj.nextLine());
			System.out.println();
			System.out.print("ISBN :");
			Isbn= myObj.nextLine();


			livreRepo.save(new Livre(Titre,Auteur,Maison_edt,new Date(),NbPage,Isbn,new Date(),true));
			 System.out.println("Livre Ajouté !!");

		}
		if(userName==2){
			System.out.println("------  Liste des livres -------");
			for(Livre livre: livreRepo.findAll()) {
				System.out.println(livre.toString());
			}
		}
		if(userName==4) {
			System.out.println("------  update des livres -------");

		}
		if(userName==3) {
			System.out.println("------  Supprimer un livre -------");
			  Livre Dellivre;
             int trv=0;




				int choix=ListeChoixSupt();
				int Id_livre;

				switch (choix){
					case 1: System.out.print("ID de livre a supprimer :");
						Id_livre = Integer.parseInt(myObj.nextLine());
						for(Livre livre: livreRepo.findAll()) {
							if (livre.getID().equals(Id_livre)) {
								livreRepo.delete(livre);
								System.out.println("Livre  " + livre.getTitre() + " est supprimer");
								trv = 1;
							}
						}break;
					case 2: System.out.print("Titre de livre a supprimer :");
						Auteur = myObj.nextLine();
						for(Livre livre: livreRepo.findAll()) {
							if (livre.getTitre().equals(Auteur)) {
								livreRepo.delete(livre);
								System.out.println("Livre " +livre.getTitre()+ " est supprimer");
								trv = 1;
							}
						}break;

				    case 3: System.out.print("Nom d'Auteur de livre a supprimer :");
						Titre = myObj.nextLine();
						for(Livre livre: livreRepo.findAll()) {
							if (livre.getAuteur().equals(Titre)) {
								livreRepo.delete(livre);
								System.out.println("Livre " + livre.getTitre()+ " est supprimer");
								trv = 1;
							}
						}
						break;
			}
			if(trv==0){
				System.out.println("Livre introuvable");
			}

		}


		}
		int ListeChoixSupt(){
				 	int choix=0;
			Scanner myObj = new Scanner(System.in);

				do{
					System.out.println("1*Id");
					System.out.println("2*Titre");
					System.out.println("3*Auteur");
					 choix=Integer.parseInt(myObj.nextLine());
				}while(choix==0);

				return choix ;
	}

	}

