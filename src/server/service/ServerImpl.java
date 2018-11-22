/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.service;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import server.model.Performance;
import server.model.PerformanceWrapper;
import server.util.Initializer;

/**
 *
 * @author harry
 */
public abstract class ServerImpl {

    public static final int port = 4444;
    private static transient ServerSocket serverSocket = null;

    public static Thread serverThread;

    protected static transient List<PerformanceWrapper> performances;
    

    static void initServer() throws Exception {

        serverThread = new Thread() {

            @Override
            public void run() {

                try {

                    serverSocket = new ServerSocket(port);

                    do {

                        Socket socket = serverSocket.accept();

                        handleConnection(socket);

                    } while (!serverSocket.isClosed());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        };

        performances = Initializer.loadPerformances();
        
        
    }

    protected static void handleConnection(final Socket socket) throws Exception {

        new Handler(socket).start();

    }

    protected static void startServer() throws Exception {
        initServer();
        serverThread.start();

        System.out.println("\n\tServer started at 127.0.0.1:4444 ");
    }

    protected static void stopServer() throws Exception {
        serverSocket.close();
    }

    protected static void listPerformances() {
        performances.stream().forEach((performance) -> {
            Server.log(performance);
        });
    }

    protected static void addPerformance(String cmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected static void editPerformance(String cmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected static void deletePerformance(String cmd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
