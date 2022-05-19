package sufod;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import sufod.entity.Admin;
import sufod.entity.Attaque;
import sufod.entity.Classe;
import sufod.entity.Equipement;
import sufod.entity.Ingredient;
import sufod.entity.Joueur;
import sufod.entity.Metier;
import sufod.entity.Monstre;
import sufod.entity.PartieCorps;
import sufod.entity.Personnage;
import sufod.entity.TypeAtt;

import sufod.services.AttaqueService;
import sufod.services.CompteServices;
import sufod.services.ItemService;
import sufod.services.MonstreService;
import sufod.services.PersonnageService;

public class AppSpring {
	@Autowired
	private CompteServices compteServices;
	
	@Autowired
	private AttaqueService attaqueService;
	
	@Autowired
	private PersonnageService personnageService;
	
	@Autowired
	private MonstreService monstreService;
	
	@Autowired
	private ItemService itemService;
	
	public void init() {
		
		
		
	
		
		

		
		Attaque a1 = new Attaque();
		a1.setCoupcritique(12);
		a1.setDegats(11);
		a1.setNom("NomattaqueTest1");
		a1.setPaBase(10);
		a1.setPrecision(9);
		a1.setType(TypeAtt.Distance);
		
		Attaque a2 = new Attaque();
		a2.setCoupcritique(121);
		a2.setDegats(131);
		a2.setNom("NomattaqueTest2");
		a2.setPaBase(101);
		a2.setPrecision(919);
		a2.setType(TypeAtt.Physique);
		
		Attaque a3 = new Attaque();
		a3.setCoupcritique(51);
		a3.setDegats(52);
		a3.setNom("NomattaqueTest3");
		a3.setPaBase(53);
		a3.setPrecision(54);
		a3.setType(TypeAtt.Magique);
		
		
		attaqueService.create(a1);
		attaqueService.create(a2);
		attaqueService.create(a3);
	
	Equipement e2 = new Equipement();
	e2.setAttDistance(111);
	e2.setAttMagique(222);
	e2.setAttPhysique(333);
	e2.setDefDistance(444);
	e2.setDefMagique(555);
	e2.setDefPhysique(666);
	e2.setDescription("EquipementTestDescription3");
	e2.setDropChance(888);
	e2.setEsquive(999);
	e2.setLibelle("EquipementTest2");
	e2.setLocalisation(PartieCorps.bras_droit);
	e2.setPv(1000);
	
	
	Equipement e3 = new Equipement();
	e3.setAttDistance(101);
	e3.setAttMagique(212);
	e3.setAttPhysique(323);
	e3.setDefDistance(434);
	e3.setDefMagique(545);
	e3.setDefPhysique(656);
	e3.setDescription("EquipementTestDescription3");
	e3.setDropChance(878);
	e3.setEsquive(989);
	e3.setLibelle("EquipementTest2");
	e3.setLocalisation(PartieCorps.bras_droit);
	e3.setPv(2000);
	
	
	Personnage p1 = new Personnage();
	p1.setAttDistance(11);
	p1.setDefDistance(22);
	p1.setPvMax(33);
	p1.setEsquive(44);
	p1.setMetier(Metier.Mineur);
	p1.setNiveau(55);
	p1.setXp(66);
	p1.setClasse(Classe.Cra);
	Set<Attaque> setAtt = new HashSet<Attaque>();
	setAtt.add(a1);
	setAtt.add(a2);
	p1.setAttaques(setAtt);
	p1.setEquipBras(e2.getId());
	
	//p1.setEquipTete(e3);
	
	personnageService.create(p1);
	
	
	Monstre m1 = new Monstre();
	m1.setAttDistance(1);
	m1.setAttMagique(2);
	m1.setAttPhysique(3);
	m1.setClasse(Classe.Physique);
	m1.setDefDistance(5);
	m1.setDefMagique(6);
	m1.setDefPhysique(7);
	m1.setDescription("DescriptionMonstreTest");
	m1.setDrop(9);
	m1.setEsquive(10);
	m1.setNiveau(11);
	m1.setNom("NomMonstreTest");
	m1.setPa(13);
	m1.setPaMax(14);
	m1.setPm(15);
	m1.setPmMax(16);
	m1.setPv(17);
	m1.setPvMax(18);
	m1.setVitesse(19);
	
	monstreService.create(m1);
	
	
	
	
	
	Equipement e1 = new Equipement();
	e1.setAttDistance(1);
	e1.setAttMagique(2);
	e1.setAttPhysique(3);
	e1.setDefDistance(4);
	e1.setDefMagique(5);
	e1.setDefPhysique(6);
	e1.setDescription("EquipementTestDescription");
	e1.setDropChance(8);
	e1.setEsquive(9);
	e1.setLibelle("EquipementTest");
	e1.setLocalisation(PartieCorps.jambieres);
	e1.setPv(12);

	
	Ingredient i1 = new Ingredient();
	i1.setDescription("IngredientTest");
	i1.setDropChance(3);
	i1.setLibelle("Ingredient");
	
	
	itemService.create(i1);
	itemService.create(e1);
	itemService.create(e2);
	itemService.create(e3);
	
	
	
		Admin admin = new Admin();
		admin.setMail("mailTest");
		admin.setNom("Nomtest");
		admin.setPrenom("PrenomTest");
		admin.setPassword("PasswordTest");
		admin.setPseudo("Pseudotest");
		
		compteServices.create(admin);
		
		
		
		Joueur j1 = new Joueur();
		j1.setMail("Joueurmail");
		j1.setNom("JoueurNom");
		j1.setPrenom("JoueurPrenom");
		j1.setPassword("JoueurMdp");
		j1.setPseudo("JoueurPseudo");
		Set<Personnage> setPer = new HashSet<Personnage>();
		setPer.add(p1);
		j1.setPersonnage(setPer);
		
		compteServices.create(j1);
	
	}
	
	public void run(String... args) {
		init();
	}

}
