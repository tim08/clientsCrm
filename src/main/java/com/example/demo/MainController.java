package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller// This means that this class is a Controller
public class MainController {

    @Autowired
    private ClientUlRepository clientUlRepository;

    @Autowired
    private ClientIpRepository clientIpRepository;

    @Autowired
    private ClientRepository clientRepository;



    @GetMapping(
            value = "/")
    public String main() {
        return "index";
    }

    @GetMapping(
            value = "find")
    public String find(@RequestParam Integer id, Model model) {
        Optional<Client> client=  clientRepository.findById(id);
        model.addAttribute("client", client);
        return "result";
    }

    @GetMapping("/add_new_client_ip")
    public String add_new_client_ip(Model model) {
        model.addAttribute("client", new ClientIp());
        return "add_new_client_ip";
    }

    @GetMapping("/add_new_client_ul")
    public String add_new_client_ul(Model model) {
        model.addAttribute("client", new ClientUl());
        return "add_new_client_ul";
    }

    @PostMapping("/submit_client_ul")
    public String submit_client_ul(@ModelAttribute ClientUl clientUl, Model model) {

//        Статус клиента рассчитывается как значение первой цифры ID клиента плюс числовое значение года из поля DATE_CREATED плюс :
//
//        Для объектов CLIENT_UL: значение ИНН как числа.
//        Для объектов CLIENT_IP: значение  PASSPORT_NUMBER как числа.

        clientUlRepository.save(clientUl);

        model.addAttribute("clientUl", clientUl);
        model.addAttribute("message", "This is message from flash");
        return "index";
    }

    @PostMapping("/submit_client_ip")
    public String submit_client_ip(@ModelAttribute ClientIp clientIp, Model model) {

        clientIp.status = "active";
        clientIpRepository.save(clientIp);

        return "index";
    }

}