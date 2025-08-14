/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.norbertdominkiewicz.adminhut.models;

/**
 *
 * @author norbert
 */
public abstract class Service {
    private String name;
    private String version;
    private boolean running;
    private String workDir;
    public Service(String name, String version){
        this.name = name;
        this.version = version;
    }
    public String getName() { return name; }
    public String getVersion() { return version; }
    public boolean isRunning() { return running; }
    public void setRunning(boolean state) { running = state; } 
}
