/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.util.Date;

/**
 *
 * @author Arnold
 * 
 */
public class Performance{
    
    private final String band, genre;
    
    private final Date date;
    
    private int tickets; 
    
    public Performance(String band, String genre, Date date, int tickets){
         
        this.band = band;
        
        this.genre = genre;
        
        this.date = date;
        
        this.tickets = tickets;
        
    }            
    
    /**
     * @return the band
     */
    public String getBand() {
        return band;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the tickets
     */
    public int getAvailableTickets() {
        return tickets;
    }
    
    public boolean isAvailable() {
        return tickets > 0 && date.after(new Date());
    }
    
    public boolean sell(int qty) {
        
        if(tickets > qty){
            
            tickets -= qty;
            
            return true;  
            
        }     
        
        return false;
    }

    @Override
    public String toString() {
        
        return    "\nBand: " + band
                + "\nGenre: " + genre
                + "\nDate: " + date
                + "\nAvailable Tickets: " + tickets;       
        
    }
    
    
    
}
