package model;

import model.FileHandler;
import model.Ticket;
import model.TicketStorage;

import java.util.Map;

public class ReadTickets
{
    public static void main(String[] arg)
    {
        TicketStorage ticketStorage = (TicketStorage) FileHandler.load("Files/ticketStorage.ser");
        for (Map.Entry<Integer, Ticket> set : ticketStorage.getTickets().entrySet())
        {
            Ticket temp = set.getValue();
            System.out.println(temp.toString());
        }
    }
}
