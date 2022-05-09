package test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sufod.config.AppConfig;
import sufod.entity.Monstre;
import sufod.services.MonstreService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class MonstreServiceTest2 {

	@Autowired
	MonstreService monstreService;
	
	@Test
	void insertMonstreTest() {
		Monstre monstre = new Monstre();
		monstre.setNom("test");
		monstreService.create(monstre);
}

}
