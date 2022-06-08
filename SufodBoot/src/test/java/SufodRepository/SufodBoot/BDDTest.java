package SufodRepository.SufodBoot;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import SufodRepository.SufodBoot.entity.Admin;
import SufodRepository.SufodBoot.entity.Attaque;
import SufodRepository.SufodBoot.entity.Classe;
import SufodRepository.SufodBoot.entity.Equipement;
import SufodRepository.SufodBoot.entity.Ingredient;
import SufodRepository.SufodBoot.entity.Item;
import SufodRepository.SufodBoot.entity.Joueur;
import SufodRepository.SufodBoot.entity.Metier;
import SufodRepository.SufodBoot.entity.Monstre;
import SufodRepository.SufodBoot.entity.PartieCorps;
import SufodRepository.SufodBoot.entity.Personnage;
import SufodRepository.SufodBoot.entity.TypeAtt;
import SufodRepository.SufodBoot.services.AttaqueService;
import SufodRepository.SufodBoot.services.CompteServices;
import SufodRepository.SufodBoot.services.ItemService;
import SufodRepository.SufodBoot.services.MonstreService;
import SufodRepository.SufodBoot.services.PersonnageService;

@SpringBootTest
public class BDDTest {
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

	@Test
	@Transactional
	@Commit
	public void init() {

		Attaque a1 = new Attaque();
		a1.setDegats(11);
		a1.setNom("Nom_Attaque_Test_1");
		a1.setType(TypeAtt.Distance);

		Attaque a2 = new Attaque();
		a2.setDegats(131);
		a2.setNom("Nom_Attaque_Test_2");
		a2.setType(TypeAtt.Physique);

		Attaque a3 = new Attaque();
		a3.setDegats(52);
		a3.setNom("Nom_Attaque_Test_3");
		a3.setType(TypeAtt.Magique);

		attaqueService.create(a1);
		attaqueService.create(a2);
		attaqueService.create(a3);

		Equipement e2 = new Equipement();
		e2.setAttaque(111);
		e2.setDefense(222);
		e2.setDescription("Description test de E2");
		e2.setDropChance(888);
	
		e2.setLibelle("Equipement_Test_2");
		e2.setLocalisation(PartieCorps.bras_droit);
		e2.setPv(1000);

		itemService.create(e2);

		Equipement e3 = new Equipement();
		e3.setAttaque(101);
		e3.setDefense(212);
		e3.setDescription("Description test de E3");
		e3.setDropChance(878);
		
		e3.setLibelle("Equipement_Test_3");
		e3.setLocalisation(PartieCorps.bras_droit);
		e3.setPv(2000);

		itemService.create(e3);
		Admin admin = new Admin();
		admin.setMail("mailTest");
		admin.setNom("Nomtest");
		admin.setPrenom("PrenomTest");
		admin.setPassword("PasswordTest");
		admin.setPseudo("Pseudotest");
		
		Joueur j1 = new Joueur();
		j1.setMail("Joueurmail");
		j1.setNom("JoueurNom");
		j1.setPrenom("JoueurPrenom");
		j1.setPassword("JoueurMdp");
		j1.setPseudo("JoueurPseudo");
		

	

		compteServices.create(j1);

		compteServices.create(admin);
		Personnage p1 = new Personnage();
		p1.setAttaque(a3);;
		p1.setDefense(22);
		p1.setPvMax(33);
		;
		p1.setNiveau(55);
		p1.setXp(66);
		p1.setClasse(Classe.Cra);
		Set<Item> setEquip = new HashSet<Item>();
		setEquip.add(e3);
		p1.setItems(setEquip);
		p1.setCompte(j1);

		// p1.setEquipTete(e3);
		personnageService.create(p1);

		Monstre m1 = new Monstre();
		m1.setAttaque(a1);
		
		m1.setClasse(Classe.Physique);
		m1.setDefense(5);
		m1.setDescription("DescriptionMonstreTest");
		m1.setDrop(9);

		m1.setNiveau(11);
		m1.setNom("NomMonstreTest");

		m1.setPv(17);
		m1.setPvMax(18);

		monstreService.create(m1);

		Equipement e1 = new Equipement();
		e1.setAttaque(1);
		e1.setDefense(2);
		e1.setDescription("EquipementTestDescription");
		e1.setDropChance(8);
		e1.setLibelle("EquipementTest");
		e1.setLocalisation(PartieCorps.jambieres);
		e1.setPv(12);

		Ingredient i1 = new Ingredient();
		i1.setDescription("IngredientTest");
		i1.setDropChance(3);
		i1.setLibelle("Ingredient");
		

		itemService.create(i1);
		itemService.create(e1);

		

		

	}
}
