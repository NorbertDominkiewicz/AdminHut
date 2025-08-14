/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.norbertdominkiewicz.adminhut.controllers;

import com.norbertdominkiewicz.adminhut.services.ApacheService;
import com.norbertdominkiewicz.adminhut.services.NodeService;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import com.norbertdominkiewicz.adminhut.models.Service;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author Norbert
 */
public class DashboardController {
    @FXML
    private HBox servicesContainer;
    
    public void initialize() {
    addServiceCard(new ApacheService("2.4.54"));
    addServiceCard(new NodeService("20.5.1"));
    }
    
    public void close(){
        System.exit(0);
    }

    private void addServiceCard(Service service) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/norbertdominkiewicz/adminhut/fxml/components/service-card.fxml"));
            Node card = loader.load();
            ServiceCardController controller = loader.getController();
            controller.setService(service);
            servicesContainer.getChildren().add(card);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
