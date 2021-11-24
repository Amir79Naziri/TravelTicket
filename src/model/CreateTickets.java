package model;



public class CreateTickets
{
    public static void main(String[] args)
    {
        TicketStorage ticketStorage = new TicketStorage();
        ticketStorage.getTickets().put(747, new Ticket("Tehran", "Mashhad", "Turkish Airlines", 23,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 747, 500));

        ticketStorage.getTickets().put(748, new Ticket("Tehran", "Shiraz", "Qatar Airlines", 2,
                0, 3, 30, 2021, 2, 9,
                2020, 12, 21, 748, 1200));

        ticketStorage.getTickets().put(749, new Ticket("Shiraz", "Isfahan", "Chinese Airlines", 3,
                0, 3, 30, 2021, 2, 9,
                2020, 12, 21, 749, 300));

        ticketStorage.getTickets().put(750, new Ticket("Isfahan", "Mashhad", "Turkish Airlines", 7,
                0, 3, 30, 2021, 2, 8,
                2020, 12, 21, 750, 400));

        ticketStorage.getTickets().put(751, new Ticket("Tehran", "Kish", "Qatar Airlines", 8,
                0, 3, 30, 2021, 2, 8,
                2020, 12, 21, 751, 800));

        ticketStorage.getTickets().put(752, new Ticket("Kish", "Shiraz", "Bangladesh Airlines", 1,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 752, 1600));

        ticketStorage.getTickets().put(753, new Ticket("Shiraz", "Tehran", "British Airlines", 23,
                0, 3, 30, 2021, 2, 21,
                2020, 12, 21, 753, 5200));

        ticketStorage.getTickets().put(754, new Ticket("Kish", "Mashhad", "Pegasus Airlines", 19,
                0, 3, 30, 2021, 2, 5,
                2020, 12, 21, 754, 150));

        ticketStorage.getTickets().put(755, new Ticket("Mashhad", "Isfahan", "Turkish Airlines", 15,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 755, 1800));

        ticketStorage.getTickets().put(756, new Ticket("Isfahan", "Kish", "Pegasus Airlines", 14,
                0, 3, 30, 2021, 2, 9,
                2020, 12, 21, 756, 2250));

        ticketStorage.getTickets().put(757, new Ticket("Kish", "Mashhad", "American Airlines", 13,
                0, 3, 30, 2021, 2, 7,
                2020, 12, 21, 757, 3500));

        ticketStorage.getTickets().put(758, new Ticket("Shiraz", "Kish", "British Airlines", 18,
                0, 3, 30, 2021, 2, 8,
                2020, 12, 21, 758, 700));

        ticketStorage.getTickets().put(759, new Ticket("Mashhad", "Kish", "Qatar Airlines", 14,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 759, 600));

        ticketStorage.getTickets().put(760, new Ticket("Shiraz", "Isfahan", "Qatar Airlines", 16,
                0, 3, 30, 2021, 2, 5,
                2020, 12, 21, 760, 1980));

        ticketStorage.getTickets().put(761, new Ticket("Isfahan", "shiraz", "Bangladesh Airlines", 6,
                0, 3, 30, 2021, 2, 9,
                2020, 12, 21, 761, 1900));

        ticketStorage.getTickets().put(762, new Ticket("Tehran", "Mashhad", "Bangladesh Airlines", 2,
                0, 3, 30, 2021, 2, 5,
                2020, 12, 21, 762, 690));

        ticketStorage.getTickets().put(763, new Ticket("Mashhad", "Kish", "Qatar Airlines", 1,
                0, 3, 30, 2021, 2, 8,
                2020, 12, 21, 763, 200));

        ticketStorage.getTickets().put(764, new Ticket("Shiraz", "Isfahan", "Pegasus Airlines", 20,
                0, 3, 30, 2021, 2, 9,
                2020, 12, 21, 764, 550));

        ticketStorage.getTickets().put(765, new Ticket("Isfahan", "shiraz", "British Airlines", 7,
                0, 3, 30, 2021, 2, 8,
                2020, 12, 21, 765, 3550));

        ticketStorage.getTickets().put(766, new Ticket("Tehran", "Mashhad", "Bangladesh Airlines", 5,
                0, 3, 30, 2021, 2, 7,
                2020, 12, 21, 766, 1750));

        ticketStorage.getTickets().put(767, new Ticket("Tehran", "Mashhad", "American Airlines", 4,
                0, 3, 30, 2021, 2, 8,
                2020, 12, 21, 767, 1750));

        ticketStorage.getTickets().put(768, new Ticket("Tehran", "Mashhad", "Qatar Airlines", 3,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 768, 500));

        ticketStorage.getTickets().put(769, new Ticket("Mashhad", "Kish", "Qatar Airlines", 21,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 769, 600));

        ticketStorage.getTickets().put(770, new Ticket("Shiraz", "Kish", "American Airlines", 12,
                0, 3, 30, 2021, 2, 7,
                2020, 12, 21, 770, 1980));

        ticketStorage.getTickets().put(771, new Ticket("Isfahan", "shiraz", "Pegasus Airlines", 11,
                0, 3, 30, 2021, 2, 6,
                2020, 12, 21, 771, 1900));
        FileHandler.save(ticketStorage, "Files/ticketStorage.ser");

    }
}