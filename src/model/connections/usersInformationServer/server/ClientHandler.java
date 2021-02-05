package model.connections.usersInformationServer.server;


import model.NullUser;
import model.User;
import model.connections.usersInformationServer.serverStorage.UsersStorage;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;


/**
 * this class handles a client
 */
public class ClientHandler implements Runnable
{
    private Socket socket;
    private int id;
    private int port;
    private UsersStorage userStorage;


    /**
     * creates new Handler
     * @param socket connection
     * @param id id
     * @param port port
     * @param usersStorage usersStorage
     */
    public ClientHandler (Socket socket, int id, int port, UsersStorage usersStorage)
    {
        this.socket = socket;
        this.id = id;
        this.port = port;
        this.userStorage = usersStorage;
    }

    @Override
    public void run () {

        OutputStream out = null;
        InputStream in = null;
        try {

            if (port == 8083)
            {
                // receive
                User user;
                in = new DataInputStream (socket.getInputStream ());
                System.out.println (port + getServerName (port)
                        + "<- data received from client " + id);
                String request = ((DataInputStream) in).readUTF ();
                String[] split = request.split (" ");
                if (split[0].equals ("Login"))
                {
                    if (split[1].toCharArray ()[0] == '+')
                        user = userStorage.getUser (split[1], split[2], 1);
                    else
                        user = userStorage.getUser (split[1], split[2], 2);
                    if (user == null)
                        user = new NullUser ();
                } else // sign up
                {
                    boolean res;
                    if (split[1].toCharArray ()[0] == '+')
                        res = userStorage.hasFieldUsed (split[1], 1);
                    else
                        res = userStorage.hasFieldUsed (split[1], 2);
                    if (res)
                    {
                        user = new NullUser ();
                        System.out.println ("res is pos");
                    }
                    else
                    {
                        if (split[1].toCharArray ()[0] == '+')
                            user = new User (split[1],split[2], 1);
                        else
                            user = new User (split[1],split[2], 2);
                        userStorage.addUser (user);
                        System.out.println ("res is neg");
                    }
                }

                // send


                out = new ObjectOutputStream (socket.getOutputStream ());
                ((ObjectOutputStream) out).writeObject (user);
                System.out.println (port + getServerName (port) +
                        "-> data sent to client " + id);

            } else if (port == 4787)
            {
                // receive
                in = new ObjectInputStream (socket.getInputStream ());
                User user = (User) ((ObjectInputStream) in).readObject ();
                String res = userStorage.update (user);

                System.out.println (port + getServerName (port)
                        + "<- data received from client " + id);

                // send
                out = new DataOutputStream (socket.getOutputStream ());

                ((DataOutputStream) out).writeUTF (res);

                System.out.println (port + getServerName (port)
                        + "-> data sent to client " + id);
            }

        } catch (ClassNotFoundException e) {
            System.out.println (port + getServerName (port)
                    + "Some thing went wrong in reading objects from server");
        } catch (SocketException e)
        {
            System.err.println (port + getServerName (port)
                    + "Client " + id + " 's connection Terminated");
        } catch (IOException e)
        {
            System.err.println (port + getServerName (port)
                    + "Some thing went wrong with Client " + id);
        } finally
        {
            try {
                if (in != null)
                    in.close ();
            }
            catch (SocketException ignore)
            {
            }
            catch (IOException e)
            {
                System.err.println (port + getServerName (port)
                        + "Some thing went wrong in closing ServerInputStream" +
                        " in Client " + id);
            }
            try {

                if (out != null)
                    out.close ();
            }
            catch (SocketException ignore)
            {
            }
            catch (IOException e)
            {
                System.err.println (port + getServerName (port)
                        + "Some thing went wrong in closing ServerOutputStream" +
                        " in Client " + id);
            }
            try {
                socket.close ();
                System.out.println (port + getServerName (port)
                        + "Client " + id + " closed");
            }
            catch (SocketException ignore)
            {
            }
            catch (IOException e)
            {
                System.err.println (port + getServerName (port)
                        + "Some thing went wrong in closing client " + id +
                        " connection");
            }
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
