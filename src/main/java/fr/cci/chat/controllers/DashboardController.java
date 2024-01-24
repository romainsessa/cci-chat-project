package fr.cci.chat.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DashboardController implements Initializable {

	@FXML
	private ProfileController profileAreaController;
	
	@FXML
	private GridPane pane;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				pane.add(new Label("o"), j, i);
			}
		}
	}
	
	public void updateUsername(String username) {
		profileAreaController.updateUsernameLabel(username);
	}

}
