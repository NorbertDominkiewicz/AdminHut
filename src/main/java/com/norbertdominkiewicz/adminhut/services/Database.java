/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.norbertdominkiewicz.adminhut.services;

/**
 *
 * @author norbert
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    
    public Connection connectDb(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
