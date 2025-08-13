/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.norbertdominkiewicz.adminhut.controllers;

/**
 *
 * @author norbert
 */


import com.norbertdominkiewicz.adminhut.services.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private TextField usernameInput;
    
    // DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    public void login(){
        System.out.println("Processing Login...");
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        connect = Database.connectDb();
        try{
            prepare = connect.prepareStatement(query);
            prepare.setString(1, usernameInput.getText());
            prepare.setString(2, passwordInput.getText());
            
            result = prepare.executeQuery();
            Alert alert;
            if(usernameInput.getText().isEmpty() || passwordInput.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please fill both inputs");
            } else {
                if(!result.next()){
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Wrong Username or Password");
                } else{
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Succes");
                    alert.setContentText("Logged in");
                }
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
