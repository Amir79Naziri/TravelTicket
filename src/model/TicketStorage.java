package model;



import java.io.*;
import java.util.HashMap;

/**
 * this class is Ticket's Storage
 */
public class TicketStorage implements Serializable
{

    private HashMap<Integer, Ticket> tickets;


    /**
     * creates a Ticket's Storage
     */
    public TicketStorage ()
    {
        tickets = new HashMap<> ();
    }


    /**
     * add ticket
     * @param ticket ticket
     */
    public synchronized void addTicket (int id, Ticket ticket)
    {
        if (ticket == null)
            return;
        tickets.put (id, ticket);
    }

    public synchronized void removeTicket (int id)
    {
        tickets.remove (id);
        FileHandler.save (this, "Files/ticketStorage.ser");
    }



    /**
     * get tickets
     * @return Ticket
     */
    public synchronized HashMap<Integer, Ticket> getTickets ()
    {
        return tickets;
    }

    /**
     * get ticket
     * @return Ticket
     */
    public synchronized Ticket getTicket(int id)
    {
        return tickets.get (id);
    }



}
