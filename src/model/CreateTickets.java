package model;



public class CreateTickets
{
    public static void main(String[] args)
    {
        TicketStorage ticketStorage = new TicketStorage();
        ticketStorage.getTickets().put(747, new Ticket("Tehran", "Mashhad", "Turkish Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 747, 500));

        ticketStorage.getTickets().put(748, new Ticket("Tehran", "Shiraz", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 748, 1200));

        ticketStorage.getTickets().put(749, new Ticket("Shiraz", "Isfahan", "Chinese Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 749, 300));

        ticketStorage.getTickets().put(750, new Ticket("Isfahan", "Mashhad", "Turkish Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 750, 400));

        ticketStorage.getTickets().put(751, new Ticket("Tehran", "Kish", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 751, 800));

        ticketStorage.getTickets().put(752, new Ticket("Kish", "Shiraz", "Bangladesh Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 752, 1600));

        ticketStorage.getTickets().put(753, new Ticket("Shiraz", "Tehran", "British Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 753, 5200));

        ticketStorage.getTickets().put(754, new Ticket("Kish", "Mashhad", "Pegasus Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 754, 150));

        ticketStorage.getTickets().put(755, new Ticket("Mashhad", "Isfahan", "Turkish Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 755, 1800));

        ticketStorage.getTickets().put(756, new Ticket("Isfahan", "Kish", "Pegasus Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 756, 2250));

        ticketStorage.getTickets().put(757, new Ticket("Kish", "Mashhad", "American Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 757, 3500));

        ticketStorage.getTickets().put(758, new Ticket("Shiraz", "Kish", "British Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 758, 700));

        ticketStorage.getTickets().put(759, new Ticket("Mashhad", "Kish", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 759, 600));

        ticketStorage.getTickets().put(760, new Ticket("Shiraz", "Isfahan", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 760, 1980));

        ticketStorage.getTickets().put(761, new Ticket("Isfahan", "shiraz", "Bangladesh Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 761, 1900));

        ticketStorage.getTickets().put(762, new Ticket("Tehran", "Mashhad", "Bangladesh Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 762, 690));

        ticketStorage.getTickets().put(763, new Ticket("Mashhad", "Kish", "Qatar Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 763, 200));

        ticketStorage.getTickets().put(764, new Ticket("Shiraz", "Isfahan", "Pegasus Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 764, 550));

        ticketStorage.getTickets().put(765, new Ticket("Isfahan", "shiraz", "British Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 765, 3550));

        ticketStorage.getTickets().put(766, new Ticket("Tehran", "Mashhad", "Bangladesh Airlines", 2,
                0, 3, 30, 2020, 12, 21,
                2020, 12, 21, 766, 1750));

        FileHandler.save(ticketStorage, "Files/ticketStorage.ser");

    }
}