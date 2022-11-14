package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class KeepToMyListController {
	@FXML
	private BorderPane initialBorderPane;
	
	@FXML
	private Button userBtn;
	
    @FXML
    private Button UsersBtn;
    
    @FXML
    private Button CalendarBtn;
    
    @FXML
    void openAddMember(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXMLFiles/AddMember.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
    @FXML
    void openUser(ActionEvent event) {
    	openScene("/FXMLFiles/User.fxml");
    }
    
    @FXML
    public void openUsers(ActionEvent e) {
    	openScene("/FXMLFiles/TableView.fxml");
    }
    
    @FXML
    void openCalendar(ActionEvent event) {
    	openScene("/FXMLFiles/Calendar.fxml");
    }
    
    public void openScene(String url) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource(url));
			initialBorderPane.setCenter(root);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }

}
