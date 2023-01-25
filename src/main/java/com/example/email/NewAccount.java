package com.example.email;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAccount {
    @FXML
    TextField textField_firstName, textField_lastName, textField_userName, passwordField_password;

    public void back() throws IOException {
        nextPage("panelLogin.fxml", null)
    }
    public void save() throws IOException{
        String email = textField_userName.getText();
        String pass = passwordField_password.getText();
        String firstName = textField_firstName.getText();
        String lastName = textField_lastName.getText();
        if(!email.isEmpty() && !pass.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty()){
            Account account = new Account(firstName, lastName, email + "@custom.ir", pass);
            DataBase.accounts.add(account);
            DataBase.saveAccountstoFile();
            showMessage("Info", "Registration was Successful");
            nextPage("panelMain.fxml", account);
        }
    }
    public void nextPage(String nameFile, Account account) throws IOException{
        Stage stage = (stage) textField_firstName.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource(nameFile));
        Scene scene = new Scene(parent);
        stage.setUserData(account);
        stage.setScene(scene);
        stage.show();


    }
    public static void showMessage(String type, String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (type.equals("Info")){
            alert.setAlertType(Alert.AlertType.INFORMATION);
        }
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.getDialogPane().setPrefSize(300, 100);
        alert.showAndWait();
    }
}
