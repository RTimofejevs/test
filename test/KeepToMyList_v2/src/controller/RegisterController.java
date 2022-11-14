package controller;

import java.sql.Connection;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import application.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;
    
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private PasswordField confirmPasswordTextField;
    
    @FXML
    private Button registerButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorMessage;
    
    
    public void registerButtonOnAction(ActionEvent e) {
       	cleanMessages();
       	if(checkFieldsForErrors()) {
       		registerUser();
       	}	
    } 
    
    public void registerUser() {
    	DatabaseConnection connectNow = new DatabaseConnection();
    	Connection connectDB = connectNow.getConnection();
    	
    	String firstname = firstnameTextField.getText();
    	String lastname = lastnameTextField.getText();
    	String username = usernameTextField.getText();
    	String password = passwordTextField.getText();
    	
    	String quary = "INSERT INTO useraccounts(Firstname,Lastname,Username,Password) VALUES ('"+firstname+"','"+lastname+"','"+username+"','"+password+"')"; 
   
    	try {
    		Statement statement = connectDB.createStatement();
    		statement.executeUpdate(quary);
    		System.out.println("Registration was successful");
    		Stage stage = (Stage) registerButton.getScene().getWindow();
    		stage.close();
    	} catch(Exception e) {
    		errorMessage.setText("User already exists.");
    	}
    }

    public boolean checkFieldsForErrors() {	
    	List<TextField> registerFields = new LinkedList();
    	registerFields.add(firstnameTextField);
    	registerFields.add(lastnameTextField);
    	registerFields.add(usernameTextField);
    	registerFields.add(passwordTextField);
    	registerFields.add(confirmPasswordTextField); 
        
    	for(TextField field : registerFields) {
    		if(field.getText().isBlank()) {
    			errorMessage.setText("Please fill up all fields");
    			return false;
    		} else if(!passwordTextField.getText().equals(confirmPasswordTextField.getText())) {
    			errorMessage.setText("Password doesn't match");
    			return false;
    		} 
    	} 
    	return true;
    }
    
    public void cancelButtonOnAction(ActionEvent e) {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    	//Platform.exit();
    }
    
    public void cleanMessages() {
    	errorMessage.setText("");
    	errorMessage.setText("");
    }
}
