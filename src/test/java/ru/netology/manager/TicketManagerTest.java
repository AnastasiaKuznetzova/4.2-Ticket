package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
   TicketRepository repository = new TicketRepository();
   TicketManager manager = new TicketManager(repository);

    Ticket first = new Ticket(1,1000, "AAA", "AAB", 100 );
    Ticket second = new Ticket(2, 2000, "AAC", "AAE", 200);
    Ticket third = new Ticket(3, 3000, "AAA", "AAB", 300);
    Ticket four = new Ticket(4, 1500, "AAH", "AAI", 150);
    Ticket five = new Ticket(5, 4000, "AAJ", "AAK", 250);
    Ticket six = new Ticket(6, 2500, "AAA", "AAB", 350);

    @BeforeEach
    void setUp() {
        manager.addTicket(first);
        manager.addTicket(second);
        manager.addTicket(third);
        manager.addTicket(four);
        manager.addTicket(five);
        manager.addTicket(six);
    }


    @Test
    void shouldfind() {
       Ticket[] expected = new Ticket[]{first,six,third};
       Ticket[] actual = manager.findAll("AAA", "AAB");
        assertArrayEquals(expected,actual);
    }


    @Test
    void shouldfindNothing(){
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("AAJ","AAI");
       assertArrayEquals(expected,actual);
    }
    @Test
    void shoulgshowOffers(){
        Ticket[] expected = new Ticket[]{first,four,second,six,third,five};
        Ticket[] actual = manager.showOffers();
        assertArrayEquals(expected,actual);
    }
}