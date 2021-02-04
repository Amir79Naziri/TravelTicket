package model.connections.usersInformationServer.server;



import model.connections.usersInformationServer.serverStorage.UsersStorage;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class handles server and response them
 */
public class ServerHandler
{
    private UsersStorage usersStorage;
    private SaveServer saveServer;
    private LoadServer loadServer;

    private FinishProcess finishProcess;

    /**
     * creates a new ServerHandler
     */
    public ServerHandler ()
    {
        loadUserStorage ();
        finishProcess = new FinishProcess ();
        saveServer = new SaveServer (usersStorage);
        loadServer = new LoadServer (usersStorage);
        new Thread (new Runnable () {
            @Override
            public void run () {
                while (true)
                {
                    try {
                        Thread.sleep (1000 * 60 * 5);
                        System.out.println ("Auto Saved");
                        saveUserStorage ();
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace ();
                    }
                }
            }
        }).start (); // Auto Save in every 5 minutes
    }

    /**
     * starts response
     */
    public void start ()
    {

        ExecutorService pool = Executors.newCachedThreadPool ();

        pool.execute (new Runnable () {
            @Override
            public void run () {
                saveServer.startServer ();
            }
        });

        pool.execute (new Runnable () {
            @Override
            public void run () {
                loadServer.startServer ();
            }
        });


        pool.shutdown ();
    }

    /**
     *
     * @return get FinishProcess
     */
    public FinishProcess getFinishProcess () {
        return finishProcess;
    }

    /**
     * saves data of users
     */
    private synchronized void saveUserStorage ()
    {
        try (ObjectOutputStream out = new ObjectOutputStream (
                new FileOutputStream (
                        new File ("./model/connections/usersInformationServer/" +
                                "/serverStorage/Files/usersData.ser")))){

            out.writeObject (usersStorage);
        } catch (IOException e)
        {
            System.out.println ("some thing went wrong in save");
        }
    }

    /**
     * load data of Users
     */
    private synchronized void loadUserStorage ()
    {
        try (ObjectInputStream in = new ObjectInputStream (
                new FileInputStream (
                        new File ("./model/connections/usersInformationServer/" +
                                "/serverStorage/Files/usersData.ser")))){
            Object o = in.readObject ();
            this.usersStorage =  (UsersStorage) o;

        } catch (FileNotFoundException e)
        {
            this.usersStorage = new UsersStorage ();
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println ("some thing was wrong in load");
        }
    }



    /**
     * this class built for save anything before termination
     */
    private class FinishProcess extends Thread
    {
        @Override
        public void run () {
            System.out.println ("Auto Saved");
            saveUserStorage ();
        }
    }
}
