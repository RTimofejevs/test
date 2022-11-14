package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMemberController {

    @FXML
    private TextField PositionField;

    @FXML
    private TextField adressField;

    @FXML
    private TextField countryField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneField;

    @FXML
    private ChoiceBox<?> phonePrefixField;

    @FXML
    private TextField salaryField;

    @FXML
    private TextField statusField;
    
    @FXML
    private Button cancelButton;

    @FXML
    private Button addButton;
    
    @FXML
    void addMember(ActionEvent event) {
    	
    }

    @FXML
    void closeWindow(ActionEvent event) {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }

}
