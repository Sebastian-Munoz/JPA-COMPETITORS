/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author usuario
 */
public class PersistenceManager {
    
    public static boolean DEBUG = true;
    public static final PersistenceManager singleton = new PersistenceManager();
    protected EntityManagerFactory emf;
    
    public static PersistenceManager getInstance(){
        return singleton;
    }

    public PersistenceManager() {
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
        if (emf==null) {
            createEntityManagerFactory();
        }
        return emf;
    }

    protected void createEntityManagerFactory() {
        this.emf= Persistence.createEntityManagerFactory("CompetitorsPU", System.getProperties());
        if(DEBUG){
         System.out.println("Persistence started at "+ new java.util.Date());
        }
    }
    
    public void closeEntityManagerFactory(){
        if (emf==null) {
            emf.close();
            emf=null;
            if (DEBUG) {
                System.out.println("Persistence finished at "+ new java.util.Date());
            }
            
        }
    }
    
}