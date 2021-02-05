package model;


import model.connections.usersInformationServer.serverStorage.UsersStorage;

import java.io.*;
import java.util.ArrayList;

/**
 * this class is Ticket's Storage
 */
public class TicketStorage implements Serializable
{

    private ArrayList<Ticket> tickets;


    /**
     * creates a Ticket's Storage
     */
    public TicketStorage ()
    {
        tickets = new ArrayList<> ();
    }


    /**
     * add ticket
     * @param ticket ticket
     */
    public synchronized void addTicket (Ticket ticket)
    {
        if (ticket == null)
            return;
        tickets.add (ticket);
    }

    /**
     * update Ticket
     * @param ticket ticket
     * @return result
     */
    public synchronized boolean update (Ticket ticket)
    {

        for (Ticket ticket1 : tickets)
        {
            if (ticket1.equals (ticket))
            {
//                ticket1.update (ticket);
                return true;
            }
        }
        return false;
    }

    /**
     * get user
     * @param index index of Ticket
     * @return Ticket
     */
    public synchronized Ticket getTicket (int index)
    {
        try {
            return tickets.get (index);
        } catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

//    /**
//     * saves ticketStorage
//     */
//    private synchronized void saveUserStorage ()
//    {
//        try (ObjectOutputStream out = new ObjectOutputStream (
//                new FileOutputStream (
//                        new File ("Files/ticketsData.ser")))){
//
//            out.writeObject (this);
//        } catch (IOException e)
//        {
//            System.out.println ("some thing went wrong in save");
//            e.printStackTrace ();
//        }
//    }
//
//    /**
//     * load ticketStorage
//     */
//    private synchronized void loadUserStorage ()
//    {
//        try (ObjectInputStream in = new ObjectInputStream (
//                new FileInputStream (
//                        new File ("Files/usersData.ser")))){
//            Object o = in.readObject ();
//            this.usersStorage =  (UsersStorage) o;
//
//        } catch (FileNotFoundException e)
//        {
//            this.usersStorage = new UsersStorage ();
//        }
//        catch (IOException | ClassNotFoundException e)
//        {
//            System.out.println ("some thing was wrong in load");
//        }
//    }


}
