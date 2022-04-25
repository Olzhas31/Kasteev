package kaz.museum.Kasteev.domains;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class GuestMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String title;

    private String content;

    private String date;

    public GuestMessage(String name, String surname, String email, String title, String message) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.title = title;
        this.content = message;
    }

    public GuestMessage(){}
}
