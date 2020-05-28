package MetroVias;


public class Person {
    Ticket ticket;

    public Person(Clock watch) {
        ticket=new Ticket(watch);
    }

    public Ticket getTicket() {
        return ticket;
    }
}
