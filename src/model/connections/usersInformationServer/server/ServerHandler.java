package model.connections.usersInformationServer.server;



import model.FileHandler;
import model.connections.usersInformationServer.serverStorage.UsersStorage;
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
        usersStorage = (UsersStorage) FileHandler.load ("Files/usersData.ser");
        if (usersStorage == null)
            usersStorage = new UsersStorage ();
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
                        FileHandler.save (usersStorage, "Files/usersData.ser");
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
     * this class built for save anything before termination
     */
    private class FinishProcess extends Thread
    {
        @Override
        public void run () {
            System.out.println ("Auto Saved");
            FileHandler.save (usersStorage, "Files/usersData.ser");
        }
    }
}
