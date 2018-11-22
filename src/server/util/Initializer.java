/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.util;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import server.model.Performance;
import server.model.PerformanceWrapper;

/**
 *
 * @author harry
 */
public class Initializer {

    public static List<PerformanceWrapper> loadPerformances() throws InitializerException {
        
        List<PerformanceWrapper> performances = new ArrayList<>();
        
        try{
            
            Node perfNode;
            
            String band, genre;
            Date date;                    
            int tickets;        
            
            Performance performance;
                                
            Document perfDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("performances");
            
            NodeList perfNodes = perfDocument.getDocumentElement().getElementsByTagName("performance");
            
            for (int pos = 0; pos < perfNodes.getLength(); pos++) {
                
                perfNode = perfNodes.item(pos);
                
                band = perfNode.getAttributes().getNamedItem("band").getTextContent();
                genre = perfNode.getAttributes().getNamedItem("genre").getTextContent();
                date = DateFormat.getDateInstance(DateFormat.LONG).parse(perfNode.getAttributes().getNamedItem("date").getTextContent());
                tickets = Integer.parseInt(perfNode.getAttributes().getNamedItem("tickets").getTextContent());
                
                performance = new Performance(band, genre, date, tickets);
                
                performances.add(new PerformanceWrapper(pos, performance));
                
            }

            
        }catch(Exception ex){
            
            throw new InitializerException(ex.getMessage(), ex);
        }
        
        return performances;       
    }

    /**
     *
     */
    public static class InitializerException extends Exception {

        private static final long serialVersionUID = 1L;

        private final String message;

        public InitializerException(String message, Throwable cause) {

            super(cause);

            this.message = message;

        }

        @Override
        public String getMessage() {
            return "The Booking Application Server could not be started because... " + message;
        }
    }
}
