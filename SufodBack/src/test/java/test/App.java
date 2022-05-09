package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DAOAttaque;
import dao.DAOCompte;
import dao.DAOVivant;
import sufod.entity.Admin;
import sufod.entity.Attaque;
import sufod.entity.Classe;
import sufod.entity.Compte;
import sufod.entity.Joueur;
import sufod.entity.Metier;
import sufod.entity.Monstre;
import sufod.entity.Personnage;
import sufod.entity.TypeAtt;
import sufod.entity.TypeCible;
import sufod.entity.Vivant;


public class App {

	static DAOAttaque daoAttaque = new DAOAttaque();
	static DAOCompte daoCompte = new DAOCompte();
	static DAOVivant daoVivant = new DAOVivant();


	static Compte connected=null;



	public static String saisieStringLn(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg+" ");
		return sc.nextLine();
	}
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print(msg+" ");
		return sc.nextLine();
	}
	public static int saisieIntLn(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg+" ");
		return sc.nextInt();
	}
	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print(msg+" ");
		return sc.nextInt();
	}



	private static void rechercheAttaque()
	{
		List<Attaque> recherche = daoAttaque.findAll();

		System.out.println("------------- Toutes les attaques -------------");
		for (Attaque a : recherche) {
			System.out.println("------");
			System.out.println(a.toStringInForm());
			System.out.println("------");
		}
		System.out.println("-----------------------------------------------");
	}
	private static void rechercheAttaqueById(int id)
	{
		Attaque a = daoAttaque.findById(id);
		System.out.println("------------- Attaque recherch�e par ID -------------");
		System.out.println(a.toStringInForm());
		System.out.println("-----------------------------------------------------");
	}
	private static void rechercheAttaqueByType(TypeAtt type)
	{
		List<Attaque> recherche = daoAttaque.findByType(type);
		System.out.println("------------- Attaque recherch�e par type -------------");
		for (Attaque a : recherche) {
			System.out.println("------");
			System.out.println(a.toStringInForm());
			System.out.println("------");
		}
		System.out.println("-------------------------------------------------------");
	}

	private static void rechercheCompte()
	{
		List<Compte> recherche = daoCompte.findAll();

		System.out.println("------------- Toutes les comptes -------------");
		for (Compte c : recherche) {
			System.out.println("------");
			System.out.println(c.toStringInForm());
			System.out.println("------");
		}
		System.out.println("-----------------------------------------------");
	}
	private static void rechercheCompteById(int id)
	{
		Compte c = daoCompte.findById(id);
		System.out.println("------------- Compte recherch�e par ID -------------");
		System.out.println(c.toStringInForm());
		System.out.println("-----------------------------------------------------");
	}
	private static void rechercheCompteByType(String type)
	{
		List<Compte> recherche = daoCompte.findByType(type);
		System.out.println("------------- Compte recherch�e par type -------------");
		for (Compte a : recherche) {
			System.out.println("------");
			System.out.println(a.toStringInForm());
			System.out.println("------");
		}
		System.out.println("-------------------------------------------------------");
	}


	private static void rechercheVivant()
	{
		List<Vivant> recherche = daoVivant.findAll();

		System.out.println("------------- Toutes les Vivants -------------");
		for (Vivant v : recherche) {
			System.out.println("------");
			if (v instanceof Personnage) {
				System.out.println(((Personnage)v).toStringInForm());
			}
			else if (v instanceof Monstre) {
				System.out.println(((Monstre)v).toStringInForm());
			}
			System.out.println("------");
		}
		System.out.println("-----------------------------------------------");
	}
	private static void rechercheVivantById(int id)
	{
		Vivant v = daoVivant.findById(id);
		System.out.println("------------- Vivant recherch�e par ID -------------");
		if (v instanceof Personnage) {
			System.out.println(((Personnage)v).toStringInForm());
		}
		else if (v instanceof Monstre) {
			System.out.println(((Monstre)v).toStringInForm());
		}
		System.out.println("-----------------------------------------------------");
	}
	private static void recherchePersonnageByIdCompte(int id)
	{
		List<Personnage> recherche = daoVivant.findByIdCompte(id);

		System.out.println("------------- Toutes les personnages de ce compte -------------");
		for (Personnage p : recherche) {
			System.out.println("------");
			System.out.println(p.toStringInForm());
			System.out.println("------");
		}
		System.out.println("-----------------------------------------------");
	}



	private static void menuConnexion() {

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = daoCompte.seConnecter(login,password);

		if(connected instanceof Admin) 
		{
			connected = (Admin) connected;
			connected.setPersonnages(daoVivant.findPersoToCompte(connected.getId()));
			operationAdmin();
		}
		else if(connected instanceof Joueur) 
		{
			connected = (Joueur) connected;
			connected.setPersonnages(daoVivant.findPersoToCompte(connected.getId()));
			menuChoixPerso();
		}
		else 
		{
			System.out.println("Identifiants invalides.");
			menuConnexion();
		}

	}

	private static void operationAdmin(){
		System.out.println("------- Menu Admin -------");
		System.out.println("1- Gestion des Persos");
		System.out.println("2- Gestion des Items");
		System.out.println("3- Gestion des Attaques");
		System.out.println("4- Quitter");

		int choix = saisieInt("Choix du menu");
		switch(choix) 
		{
		case 1 : gestionPerso();break;
		case 2 : gestionItem();break;
		case 3 : gestionAttaque();break;
		case 4 : System.exit(0);break;
		}
		operationAdmin();

	}


	private static void gestionPerso() {
		System.out.println("------- Menu Gestion Joueur -------");
		System.out.println("1- Ajouter un joueur");
		System.out.println("2- Modifier un joueur");
		System.out.println("3- Supprimer un joueur");
		System.out.println("4- Afficher tous les joueurs");
		System.out.println("5- Quitter");

		int choix = saisieInt("Choix du menu");
		switch(choix) 
		{
		case 1 : creerPerso();break;
		case 2 : modifierPerso();break;
		case 3 : suppprimerPerso();break;
		case 4 : afficherPerso();break;
		case 5 : System.exit(0);break;
		}
		operationAdmin();


	}

	private static void menuChoixPerso() {
		System.out.println("+) Cr�er un nouveau personnage");

		int i = 1;

		for (Personnage p : connected.getPersonnages()) {
			System.out.println(i +") "+p.getNom() +" niveau "+ p.getNiveau() +" ("+p.getClasse()+")" );
			i++;
		}

		String rep = saisieString(">> ");
		if (rep.equals("+")) {
			creerPerso();
		}
	}

	private static void creerPerso() {

		String nom = saisieString("Nom\n >>");
		String description = saisieString("Description\n >>");
		System.out.println(Arrays.toString(Classe.values()));
		String classe = saisieString("Classe\n >>");
		
		System.out.println(Arrays.toString(Metier.values()));
		String metier = saisieString("Metier\n >>");
		

		if (classe.equals("Yop")) {											//PVmax esqu vit paMax pmMax attMAg attPhy attDist defMag defPhy defDist pc
			Personnage p = new Personnage(nom, description, 1, Classe.valueOf(classe), 100, 10, 10, 20, 5, 10, 10, 20, 5, 3, 3, 3, Metier.valueOf(metier), connected.getId());
			daoVivant.insertPersonnage(p);
		}
		else if (classe.equals("Cra")) {
			Personnage p = new Personnage(nom, description, 1, Classe.valueOf(classe), 100, 10, 10, 20, 5, 10, 10, 20, 5, 3, 3, 3, Metier.valueOf(metier), connected.getId());
			daoVivant.insertPersonnage(p);	
		}
		else if (classe.equals("Magique")) {
			Personnage p = new Personnage(nom, description, 1, Classe.valueOf(classe), 100, 10, 10, 20, 5, 10, 10, 20, 5, 3, 3, 3, Metier.valueOf(metier), connected.getId());
			daoVivant.insertPersonnage(p); 
		}
		else if (classe.equals("Distance")) {
			Personnage p = new Personnage(nom, description, 1, Classe.valueOf(classe), 100, 10, 10, 20, 5, 10, 10, 20, 5, 3, 3, 3, Metier.valueOf(metier), connected.getId());
			daoVivant.insertPersonnage(p);
		}
		else {
			Personnage p = new Personnage(nom, description, 1, Classe.valueOf(classe), 100, 10, 10, 20, 5, 10, 10, 20, 5, 3, 3, 3, Metier.valueOf(metier), connected.getId());
			daoVivant.insertPersonnage(p);
		}


		System.out.println("Personnage cr�e");
	}

	private static void modifierPerso(){
		afficherPerso();
		int idPerso = saisieInt("Quel personnage voulez-vous modifier ?");

		String nom = saisieString("Quelle est votre nom ?");
		String description = saisieString("Quelle description voulez-vous ?");
		int niveau = saisieInt("Quel est le niveau ?");
		String classe = saisieString("Classe\n >>");
		int pvMax = saisieInt("Nombre de PV max : ");
		int esquive = saisieInt("Valeur de l'esquive': ");
		int vitesse = saisieInt("Valeur de la stat vitesse : ");
		int paMax = saisieInt("Nombre de PA max : ");
		int pmMax = saisieInt("Nombre de PM max : ");
		int attMagique = saisieInt("Valeur attaque magique : ");
		int attPhysique = saisieInt("Valeur attaque physique : ");
		int attDistance = saisieInt("Valeur attaque distance : ");
		int defMagique = saisieInt("Valeur d�fense magique : ");
		int defPhysique = saisieInt("Valeur d�fense physique : ");
		int defDistance = saisieInt("Valeur d�fense distance : ");
		String metier = saisieString("Metier\n >>");
//		Personnage p = new Personnage(nom, description, niveau, Classe.valueOf(classe), pvMax, esquive, vitesse, paMax, pmMax, attMagique, attPhysique, attDistance, defMagique, defPhysique, defDistance, defDistance, Metier.valueOf(metier), );
//		daoVivant.update(p);

	}

	private static void afficherPerso(){
		List <Vivant> listvivants = daoVivant.findAll();
		if(listvivants.isEmpty()) {System.out.println("Aucun personnages � afficher");}
		for (Vivant v : listvivants){
			System.out.println(v);
		}
	}


	private static void suppprimerPerso(){
		afficherPerso();
		int id = saisieInt("Personnage � supprimer ? (id)");
		daoVivant.delete(id);

	}




	private static void gestionItem() {
		System.out.println("------- Menu Gestion des Items -------");
		System.out.println("1- Ajout item");
		System.out.println("2- Modifier item");
		System.out.println("3- Afficher tous les items");
		System.out.println("4- Supprimer un item");
		System.out.println("5- Retour");

		int choix = saisieInt("Choix du menu");
		switch(choix) 
		{
		case 1 : ajoutItem();break;
		case 2 : modifierItem();break;
		case 3 : afficherItem();break;
		case 4 : supprimerItem();break;
		case 5 : menuPrincipal();break;
		}
		gestionItem();


	}



	private static void ajoutItem() {



	}


	private static void modifierItem() {



	}


	private static void afficherItem() {

	}


	private static void supprimerItem() {

	}

	private static void gestionAttaque() {
		System.out.println("------- Menu Gestion des Attaques -------");
		System.out.println("1- Ajout attaque");
		System.out.println("2- Modifier attaque");
		System.out.println("3- Afficher toutes les attaques");
		System.out.println("4- Supprimer attaque");
		System.out.println("5- Retour");

		int choix = saisieInt("Choix du menu");
		switch(choix) 
		{
		case 1 : ajoutAttaque();break;
		case 2 : modifierAttaque();break;
		case 3 : afficherAttaque();break;
		case 4 : supprimerAttaque();break;
		case 5 : menuPrincipal();break;
		}
		gestionAttaque();
	}
	private static void ajoutAttaque() {

		String nom = saisieString("Nom\n >>");
		String description = saisieString("Description\n >>");
		int niveau = saisieInt("Niveau\n >>");
		System.out.println(Arrays.toString(TypeCible.values()));
		String typeCible = saisieString("Sorte d'attaque\n >>");
		System.out.println(Arrays.toString(TypeAtt.values()));
		String typeAttaque = saisieString("Type d'attaque\n >>");
		int degatMagique = saisieInt("Degats Magique de l'attaque\n >>");
		int degatPhysique = saisieInt("Degats Physique de l'attaque\n >>");
		int degatDistance = saisieInt("Degats Distance de l'attaque\n >>");
		double chanceToucher = saisieInt("Chance de toucher\n >>");
		double chanceCritique = saisieInt("Chance de critique\n >>");
		int coutPA = saisieInt("Cout en PA\n >>");
		int coutPM = saisieInt("Cout en PM\n >>");
		int malusPA = saisieInt("Malus en PA\n >>");
		int malusPM = saisieInt("Malus en PM\n >>");

		Attaque a = new Attaque(nom, description, niveau, TypeCible.valueOf(typeCible), TypeAtt.valueOf(typeAttaque), degatMagique, degatPhysique, degatDistance, chanceToucher, chanceCritique, coutPA, coutPM, malusPA, malusPM);
		daoAttaque.insert(a);
		


		System.out.println("Attaque cr�ee");

	}


	private static void modifierAttaque() {
		String nom = saisieString("Nom\n >>");
		String description = saisieString("Description\n >>");
		int niveau = saisieInt("Niveau\n >>");
		System.out.println(Arrays.toString(TypeCible.values()));
		String typeCible = saisieString("Sorte d'attaque\n >>");
		System.out.println(Arrays.toString(TypeAtt.values()));
		String typeAttaque = saisieString("Type d'attaque\n >>");
		int degatMagique = saisieInt("Degats Magique de l'attaque\n >>");
		int degatPhysique = saisieInt("Degats Physique de l'attaque\n >>");
		int degatDistance = saisieInt("Degats Distance de l'attaque\n >>");
		double chanceToucher = saisieInt("Chance de toucher\n >>");
		double chanceCritique = saisieInt("Chance de critique\n >>");
		int coutPA = saisieInt("Cout en PA\n >>");
		int coutPM = saisieInt("Cout en PM\n >>");
		int malusPA = saisieInt("Malus en PA\n >>");
		int malusPM = saisieInt("Malus en PM\n >>");

		Attaque a = new Attaque(nom, description, niveau, TypeCible.valueOf(typeCible), TypeAtt.valueOf(typeAttaque), degatMagique, degatPhysique, degatDistance, chanceToucher, chanceCritique, coutPA, coutPM, malusPA, malusPM);
		daoAttaque.update(a);


	}


	private static void afficherAttaque() {
		List <Attaque> listattaques = daoAttaque.findAll();
		if(listattaques.isEmpty()) {System.out.println("Aucune attaque � afficher");}
		for (Attaque a : listattaques){
			System.out.println(a);
		}
	}


	private static void supprimerAttaque() {
		afficherAttaque();
		int id = saisieInt("Attaque � supprimer ? (id)");
		daoAttaque.delete(id);
	}

	private static void menuPrincipal() {

	}





	public static void main(String[] args) {
		menuConnexion();
	}

}
