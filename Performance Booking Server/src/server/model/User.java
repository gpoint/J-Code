/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author harry
 */
public class User {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1", 4444);

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());

        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

//        PerformanceWrapper pw = (PerformanceWrapper)((Action)is.readObject()).obj;
//        
//        System.out.println(pw.getID() + "    " + pw.getPerformance());
        Action response, request = new Action("list", null);

        os.writeObject(request);

        response = (Action) is.readObject();

        for (PerformanceWrapper perfW : ((List<PerformanceWrapper>) response.obj)) {

            System.out.println(perfW.getID() + "  " + perfW.getPerformance());
        }

//        os.
    }

}
