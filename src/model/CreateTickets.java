package model;



public class CreateTickets
{
    public static void main(String[] args)
    {
        TicketStorage ticketStorage = new TicketStorage();
        ticketStorage.getTickets().put(747, new Ticket("Tehran", "Mashhad", "Turkish Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 747, 500));

        ticketStorage.getTickets().put(748, new Ticket("Tehran", "Shiraz", "American Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 748, 500));

        ticketStorage.getTickets().put(749, new Ticket("Shiraz", "Isfahan", "Chinese Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 749, 500));

        ticketStorage.getTickets().put(750, new Ticket("Isfahan", "Mashhad", "Turkish Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 750, 500));

        ticketStorage.getTickets().put(751, new Ticket("Tehran", "Kish", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 751, 500));

        ticketStorage.getTickets().put(752, new Ticket("Kish", "Shiraz", "Bangladesh Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 752, 500));

        ticketStorage.getTickets().put(753, new Ticket("Shiraz", "Tehran", "British Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 753, 500));

        ticketStorage.getTickets().put(754, new Ticket("Kish", "Mashhad", "Pegasus Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 754, 500));

        ticketStorage.getTickets().put(755, new Ticket("Mashhad", "Isfahan", "Turkish Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 755, 500));

        ticketStorage.getTickets().put(756, new Ticket("Isfahan", "Kish", "Pegasus Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 756, 500));

        ticketStorage.getTickets().put(757, new Ticket("Kish", "Mashhad", "American Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 757, 500));

        ticketStorage.getTickets().put(758, new Ticket("Shiraz", "Mashhad", "British Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 758, 500));

        ticketStorage.getTickets().put(759, new Ticket("Mashhad", "Kish", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 759, 500));

        ticketStorage.getTickets().put(760, new Ticket("Shiraz", "Isfahan", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 760, 500));

        ticketStorage.getTickets().put(761, new Ticket("Isfahan", "shiraz", "Bangladesh Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 761, 500));

        ticketStorage.getTickets().put(762, new Ticket("Tehran", "Kish", "Turkish Airline", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 762, 500));

        FileHandler.save(ticketStorage, "Files/ticketStorage.ser");

    }
}