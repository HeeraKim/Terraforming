package application;

import application.data.PlanetData;
import application.nio.archive.ObjectSerialization;
import application.page.initial.BaseInitial;
import application.page.initial.Initial;
import application.page.start.BaseStart;
import application.page.start.Start;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			// Path to the planet data
			final String planetDataPath = "terraforming.bin";
			
			// Load the data
			final PlanetData planetData = (PlanetData) new ObjectSerialization().load(planetDataPath, new PlanetData());
			
			// Plain pages
			final Initial initial = new BaseInitial();
			final Start start = new BaseStart(planetData);
			
			// Navigate to Start page from initial page
			initial.addNewEvent(()->{
				try {
					stage.setScene(start.scene());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			});

			// Stage
			stage.setScene(initial.scene());
			stage.setTitle("Terraforming");
			stage.setWidth(825);
			stage.setHeight(550);
			stage.setOnCloseRequest(e->{
				try {
					// Save the data
					new ObjectSerialization().save(planetDataPath, planetData);
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			});
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
