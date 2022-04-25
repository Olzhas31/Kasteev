package kaz.museum.Kasteev.controllers;

import kaz.museum.Kasteev.domains.GuestMessage;
import kaz.museum.Kasteev.repositories.GuestMessageRepository;
import kaz.museum.Kasteev.services.GuestMessageService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final GuestMessageService guestMessageService;

    @GetMapping({"/", "/admin"})
    public String showIndexPage(Model model){
        List<GuestMessage> messages = guestMessageService.getAllMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("message", new GuestMessage());
        return "index";
    }

    @PostMapping("/add")
    public String addMessage(@ModelAttribute("message") GuestMessage guestMessage){
        guestMessageService.save(guestMessage);
        return "redirect:/";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete")
    public String deleteMessage(@RequestParam("id") Long id){
        guestMessageService.deleteById(id);
        return "redirect:/";
    }
}
