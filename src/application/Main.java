package application;

import application.page.initialmachine.BaseInitialMachinePage;
import application.page.initialmachine.InitialMachinePage;
import application.page.initialplanet.BaseInitialPlanetPage;
import application.page.initialplanet.InitialPlanetPage;
import application.page.title.BaseTitlePage;
import application.page.title.TitlePage;
import application.planet.BasePlanet;
import application.planet.Planet;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			// Planet
			final Planet planet = new BasePlanet();
			
			// TitlePage
			final TitlePage titlePage = new BaseTitlePage();
			
			// InitialPlanetPage
			final InitialPlanetPage initialPlanetPage = new BaseInitialPlanetPage(planet);
			
			// InitialMachinePage
			final InitialMachinePage initialMachinePage = new BaseInitialMachinePage();
			
			// From TitlePage to InitialPlanetPage
			titlePage.addNewEvent(()->{
				try {
					initialPlanetPage.display(stage);
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			});
			
			// From InitialPlanetPage to InitialMachinePage
			initialPlanetPage.addNextEvent(()->{
				try {
					initialMachinePage.display(stage);
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			});
			
			// From InitialMachinePage to InitialPlanetPage
			initialMachinePage.addBackEvent(()->{
				try {
					initialPlanetPage.display(stage);
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			});
			
			// Stage
			stage.setTitle("Terraforming");
			stage.setWidth(825);
			stage.setHeight(550);
			stage.setOnCloseRequest(e->{
				try {
					
				} catch (Exception exception) {
					throw new RuntimeException(exception);
				}
			});
			
			// Display title page
			titlePage.display(stage);
			
			// Show stage
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
