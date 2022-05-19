package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sufod.AppSpring;
import sufod.config.AppConfig;

public class MainRun {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(AppConfig.class);
		
		aca.getBeanFactory().createBean(AppSpring.class).run();
		
		aca.close();
		
		
	}

}
