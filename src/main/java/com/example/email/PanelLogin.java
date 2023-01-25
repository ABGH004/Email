package com.example.email;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PanelLogin {
    @FXML
    TextField textField_email , textField_password;
    public void initialize() throws IOException{

    }
    public void login() throws IOException {
        String email = textField_email.getText();
        String password = textField_password.getText();
        if (!email.isEmpty() && !password.isEmpty()){
            Account account = DataBase.findEmail(email);
            if (account==null || !account.getPassword().equals(password)){
                showMessage("Error", "Wrong Input");

            } else {
                showMessage("Info", "login was successful");
                nextPage("panelMail.fxml", account);

            }
        }
    }
    public void newAccount() throws IOException{
        nextPage("panelNewAccount.fxml", null);
    }
    public void nextPage(String nameFile, Account account) throws IOException{
        Stage stage = (stage) textField_email.getScene().getWindow();
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







