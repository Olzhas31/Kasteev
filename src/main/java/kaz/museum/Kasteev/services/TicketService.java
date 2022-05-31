package kaz.museum.Kasteev.services;

import kaz.museum.Kasteev.domains.Ticket;
import kaz.museum.Kasteev.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    public JavaMailSender emailSender;

    public int getAvailableCount() {
        List<Ticket> tickets = ticketRepository.findAllByDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        if (tickets.size()>10) return 0;
        return 10 - tickets.size();
    }

    public Ticket save(Ticket ticket) {
        ticket.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        return ticketRepository.saveAndFlush(ticket);
    }

    public void sendEmail(Ticket ticket) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h3>Qurmetti " + ticket.getName() + "! <br>" +
                "Siz museige bilet satyp aldynyz!<br> " + "</h3>" +
                "Bilet nomeriniz: " + ticket.getId() +
                "<br>Bilet uaqyty: " + ticket.getDate() +
                "<br><img src='https://cdn.qazaqstan.tv/old/articles/5/article_53215.jpg?w=928&h=522&format=jpg&resize=aspectfill&g=center'>";

        message.setContent(htmlMsg, "text/html");

        helper.setTo(ticket.getEmail());

        helper.setSubject("Билет: Musei");

        this.emailSender.send(message);
    }

    public void delete(Ticket ticket1) {
        ticketRepository.delete(ticket1);
    }
}
