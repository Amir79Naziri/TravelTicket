package model.connections.usersInformationServer;

import model.connections.usersInformationServer.server.ServerHandler;
import java.util.Scanner;

/**
 * main class for run
 */
public class ServerStarter
{
    public static void main (String[] args) {
        ServerHandler serverHandler = new ServerHandler ();

        serverHandler.start ();
        Runtime.getRuntime ().addShutdownHook (serverHandler.getFinishProcess ());
        Scanner scanner = new Scanner (System.in);
        while (true)
        {
            if (scanner.nextLine ().toLowerCase ().contains ("down server"))
                System.exit (0);
        }
    }
}
