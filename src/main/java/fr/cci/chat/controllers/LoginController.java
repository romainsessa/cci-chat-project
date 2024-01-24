package fr.cci.chat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import fr.cci.chat.dao.UserDAO;
import fr.cci.chat.model.User;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	/** Model **/
	private User user;	
	
	/** Controller **/
	private DashboardController dashboardController;

	public void setDashboardController(DashboardController dashboardController) {
		this.dashboardController = dashboardController;
	}
	
	/** View **/
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
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

		UserDAO userDAO = new UserDAO();
		this.user = userDAO.findByUsername(inputUsername);
		if (this.user != null && inputPassword.equals(this.user.getPassword())) {
			errorMessage.setText("");
			dashboardController.updateUsername(this.user.getUsername());
			primaryStage.setScene(dashboardScene);
		} else {
			errorMessage.setText("Wrong username and password");
		}

	}

}