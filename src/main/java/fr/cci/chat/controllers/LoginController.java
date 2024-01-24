package fr.cci.chat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	private DashboardController dashboardController;
	
	public void setDashboardController(DashboardController dashboardController) {
		this.dashboardController = dashboardController;
	}
	
	private Scene dashboardScene;
	
	public void setDashboardScene(Scene dashboardScene) {
		this.dashboardScene = dashboardScene;
	}
	
	@FXML
	private TextField usernameField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Label errorMessage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleLogin(Event event) {
		String inputUsername = usernameField.getText();
		String inputPassword = passwordField.getText();
		
		String validUsername = "user";
		String validPassword = "password";
		if(inputUsername.equals(validUsername) && inputPassword.equals(validPassword)) {
			errorMessage.setText("");
			dashboardController.updateUsername(inputUsername);
			primaryStage.setScene(dashboardScene);
		} else {
			errorMessage.setText("Wrong username and password");
		}
	}

}