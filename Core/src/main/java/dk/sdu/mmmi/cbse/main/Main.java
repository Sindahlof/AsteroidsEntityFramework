package dk.sdu.mmmi.cbse.main;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.utils.SPILocator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("dk.sdu.mmmi.cbse.main");
		context.refresh();

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setResizable(true);
		config.setTitle("Nelda");
		config.setWindowedMode(1000, 600);


		new Lwjgl3Application((ApplicationListener) context.getBean("game"), config);
	}
}
