package org.example.college.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField password;

    @FXML
    private Button btnLogin;

    @FXML
    private CheckBox admin;

    @FXML
    private Label signUp;

    @FXML
    private TextField email;

    @FXML
    void Login(ActionEvent event) {

    }
    public void clearForm(){
        email.setText("");
        password.setText("");
        admin.setText("");

    }
}
