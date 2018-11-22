/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import server.model.Action;
import static server.service.ServerImpl.*;

/**
 *
 * @author harry
 */
public class Handler extends Thread {

    private final Socket socket;

    public Handler(Socket socket) {

        this.socket = socket;

    }

    @Override
    public void run() {
        try {

            handle(socket);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handle(Socket socket) throws Exception {

//        Server.log(socket);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

//        Server.log(is);
        try {
            
            while (is.read() != -1) {
                
            }
            
//            is.reset();
//            
            Action response = null, request = (Action) is.readObject();
            
            if(request.desc.equals("list")){
                response = new Action("list", performances);
            }

            os.writeObject(response);
            
//            System.out.println(is.available() != 0 ? is.readObject() + " " : " nothing else");
//            ; 
//            ;
//            ;
        } catch (Exception ex) {

        }

    }

}
