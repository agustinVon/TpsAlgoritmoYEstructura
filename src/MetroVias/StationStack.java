package MetroVias;

import MetroVias.PilaStatic.StackStatic;

public class StationStack {

    StackStatic<Ticket> tickets=new StackStatic<>();

    public void addTicket(Ticket tick) {
        tickets.push(tick);
    }

    public int getSize() {
        return tickets.size();
    }
}
