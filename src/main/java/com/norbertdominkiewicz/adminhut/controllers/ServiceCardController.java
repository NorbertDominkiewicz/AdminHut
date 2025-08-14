/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.norbertdominkiewicz.adminhut.controllers;

/**
 *
 * @author Norbert
 */

import com.norbertdominkiewicz.adminhut.models.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ServiceCardController {
    @FXML private Label serviceName;
    @FXML private Label serviceVersion;
    @FXML private Button toggleButton;
    @FXML private ImageView serviceImage;

    private Service service;

    public void setService(Service service) {
        this.service = service;
        loadImage();
//        serviceName.setText(service.getName());
        serviceVersion.setText("Ver: " + service.getVersion());
//        updateButtonText();
    }
    
    private void loadImage() {
        if("Apache HTTP Server".equals(service.getName())){
            serviceImage.setImage(new Image(getClass().getResource("/com/norbertdominkiewicz/adminhut/images/apacheIconPack/icons8-apache-100.png").toExternalForm()));
        } else{
            serviceImage.setImage(new Image(getClass().getResource("/com/norbertdominkiewicz/adminhut/images/nodeIconPack/icons8-nodejs-48.png").toExternalForm()));
        }
    }

    private void updateButtonText() {
        toggleButton.setText(service.isRunning() ? "Stop" : "Start");
    }

    @FXML
    private void toggleService() {
        service.setRunning(!service.isRunning());
        updateButtonText();
        // tutaj można wywołać logikę start/stop z ServiceManager
    }
}