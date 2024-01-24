package fr.cci.chat;

import java.net.URL;

import fr.cci.chat.controllers.DashboardController;
import fr.cci.chat.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		URL loginPageURL = getClass().getClassLoader().getResource("loginPage.fxml");
		FXMLLoader loginLoader = new FXMLLoader(loginPageURL);
		VBox rootLogin = (VBox) loginLoader.load();
		LoginController loginController = loginLoader.getController();
		Scene sceneLogin = new Scene(rootLogin);		
		
		URL dashboardPageURL = getClass().getClassLoader().getResource("dashboardPage.fxml");
		FXMLLoader dashboardLoader = new FXMLLoader(dashboardPageURL);
		HBox rootDashboard = (HBox) dashboardLoader.load();
		DashboardController dashboardController = dashboardLoader.getController();
		Scene sceneDashboard = new Scene(rootDashboard);
		
		URL dashboardCssURL = getClass().getClassLoader().getResource("dashboardStyle.css");
		sceneDashboard.getStylesheets().add(dashboardCssURL.toString());		
		
		loginController.setPrimaryStage(primaryStage);
		loginController.setDashboardController(dashboardController);
		loginController.setDashboardScene(sceneDashboard);
		
		primaryStage.setScene(sceneLogin);
		primaryStage.show();		
	}

}
