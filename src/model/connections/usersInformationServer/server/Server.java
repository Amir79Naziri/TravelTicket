package model.connections.usersInformationServer.server;


import model.connections.usersInformationServer.serverStorage.UsersStorage;

import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Parent Server for Login/logout
 */
public class Server
{
    private boolean running;
    private int clientId;
    private ExecutorService pool;
    private int port;
    private UsersStorage usersStorage;


    /**
     * creates a new Server
     * @param port port
     * @param usersStorage usersStorage
     */
    public Server (int port, UsersStorage usersStorage)
    {
        pool = Executors.newCachedThreadPool ();
        running = true;
        clientId = 0;
        this.port = port;
        this.usersStorage = usersStorage;
    }

    /**
     * starts server
     */
    public void startServer ()
    {
        try (ServerSocket welcomingConnection = new ServerSocket (port)) {
            System.out.println ("Server with port : " + port + getServerName (port)+
                    " Started \nWaiting for Client .....");

            while (running)
            {
                pool.execute (new ClientHandler (welcomingConnection.accept (),
                        clientId,port,usersStorage));
                System.out.println ("Server with port : " + port + getServerName (port) +
                        " connected to new Client : Client " + clientId);
                clientId++;
            }
            pool.shutdown ();
        } catch (IOException e)
        {
            e.printStackTrace ();
        }
    }

    /**
     * get server's name depends on it's port
     * @param port port
     * @return Server's name
     */
    private String getServerName (int port)
    {
        switch (port)
        {
            case 8083 : return " (Load Server) ";
            case 4787 : return " (Save Server) ";
        }
        return "";
    }




}
