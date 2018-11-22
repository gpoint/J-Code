/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author harry
 */
public class PerformanceWrapper implements Serializable {

    private static final long serialVersionUID = 6470234343988291461L;
    
    private final String band, genre;
    
    private final Date date;
    
    private int tickets, id;
    
    
    public PerformanceWrapper(int id, Performance performance){
        
        this.id = id;
        
        this.tickets = performance.getAvailableTickets();
        
        this.band = performance.getBand();
        
        this.genre = performance.getGenre();
                
        this.date = performance.getDate();
                
    }
    
    public int getID(){
        return id;
    } 
    
    public Performance getPerformance(){
        return new Performance(band, genre, date, tickets);
    }
}
