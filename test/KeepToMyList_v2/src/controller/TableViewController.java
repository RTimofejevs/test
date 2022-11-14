package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TableViewController {

	@FXML
    void addMember(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXMLFiles/AddMember.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

}
