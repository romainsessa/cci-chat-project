package fr.cci.chat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProfileController implements Initializable {
	
	@FXML
	private Label usernameLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateUsernameLabel(String username) {
		usernameLabel.setText("Your username is : " + username);
	}
	

}
