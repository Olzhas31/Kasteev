package kaz.museum.Kasteev.services;

import kaz.museum.Kasteev.domains.GuestMessage;
import kaz.museum.Kasteev.repositories.GuestMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class GuestMessageService {

    private final GuestMessageRepository guestMessageRepository;

    public void save(GuestMessage guestMessage) {
        guestMessage.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        guestMessageRepository.saveAndFlush(guestMessage);
    }

    public List<GuestMessage> getAllMessages() {
        return guestMessageRepository.findAll();
    }

    public void deleteById(Long id) {
        guestMessageRepository.deleteById(id);
    }
}
