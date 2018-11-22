/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.service;

import java.io.Console;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author harry
 */
public class Server extends ServerImpl {

    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);
    
    
    protected static String commands = ""
            + "\n"
            + "\n"
            + "usage : ["
            + "\n"
            + "\n\tstart\t:\tstarts the server"
            + "\n"
            + "\n\tstop \t:\tstops the server"
            + "\n"
            + "\n\tlist \t:\tlists all available performances with ids attached to each  "
            + "\n"
            + "\n\tadd  \t:\tadds a performance eg : 'add BAND|GENRE|DD Month YYYY|TICKETS' "
            + "\n"
            + "\n\tedit \t:\tedits a performance eg : 'edit LIST_ID|BAND|GENRE|DD Month YYYY|TICKETS' "
            + "\n"
            + "\n\tdelete\t:\tdeletes a performance with the given list id e.g : 'delete LIST_ID'  "
            + "\n"
            + "]"
            + "\n"
            + "\n";


    public static void startConsole(String user) {

        out.println("Welcome " + user);

        out.print("\nPlease type in a command from the presented list :\t");
        out.print(commands);

        String cmd;

        do {
            out.print("\n$__> ");

            cmd = in.nextLine();

            try {
                run(cmd);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } while (!cmd.equals("exit"));

    }

    private static void run(String cmd) throws Exception {

        Scanner scn = new Scanner(cmd);

//----------------------------------------------------------------start
//  checks if anything was typed       
        if (!scn.hasNext()) {
            return;
        }
//----------------------------------------------------------------end

//----------------------------------------------------------------start
//  checks the first word of the string       
        switch (scn.next()) {

            case "start":
                startServer();
                break;

            case "stop":
                stopServer();
                break;

            case "list":
                listPerformances();
                break;

            case "add":
                addPerformance(cmd);
                break;

            case "edit":
                editPerformance(cmd);
                break;

            case "delete":
                deletePerformance(cmd);
                break;
        }
//----------------------------------------------------------------end
    }

    public static String login() {

        out.println("Please Enter Your Login Credentials Below\n\n");

        out.print("\nusername: ");

        String user = in.nextLine();

        return user;

    }

    public static void log(Object obj) {

        out.print("\r\r\r\r\b ");
        out.print(obj);
        out.print("\n\n$__> ");

    }
    
    
}
