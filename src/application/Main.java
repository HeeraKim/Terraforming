package application;
	
import application.page.initial.BaseInitial;
import application.page.initial.Initial;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			// Initial Page
			final Initial initial = new BaseInitial();
			
			// Stage
			stage.setScene(initial.scene());
			stage.setTitle("Terraforming");
			stage.setWidth(825);
			stage.setHeight(550);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
