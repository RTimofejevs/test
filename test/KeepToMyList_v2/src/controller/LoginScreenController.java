package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import application.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController {

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    void loginButtonOnAction(ActionEvent event) {
		if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false) {
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String verifyLogin = "SELECT count(1) FROM useraccounts WHERE Username = '"+usernameTextField.getText()+"' AND Password = '"+passwordTextField.getText()+"'";
			try {
				Statement statement = connectDB.createStatement();
				ResultSet rs = statement.executeQuery(verifyLogin);
				
				while(rs.next()) {
					if(rs.getInt(1) == 1) {
						try {
							Parent root = FXMLLoader.load(getClass().getResource("/FXMLFiles/KeepToMyList.fxml"));
							Scene scene = new Scene(root);
							Stage stage = new Stage();
							stage.setScene(scene);
							stage.setTitle("KeepToMyList");
							stage.show();
						} catch (IOException e) {
							e.printStackTrace();
						}
						Stage stage = (Stage) loginButton.getScene().getWindow();
						stage.close();
					} else {
						errorLabel.setText("Incorrect login or password");
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(usernameTextField.getText().isBlank() == true || passwordTextField.getText().isBlank() == true){
			errorLabel.setText("Please provide login and password");
		} 
		
    }

    @FXML
    void registerButtonOnAction(ActionEvent event) {
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXMLFiles/UserRegistration.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("KeepToMyList");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
