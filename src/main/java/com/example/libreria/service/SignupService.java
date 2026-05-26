package com.example.libreria.service;

import com.example.libreria.DTO.SignupRequestDTO;
import com.example.libreria.entity.Autore;
import com.example.libreria.entity.Lettore;
import com.example.libreria.entity.User;
import com.example.libreria.enums.Tipologia;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private UserService userService;
    @Autowired
    private LettoreService lettoreService;
    @Autowired
    private AutoreService autoreService;

    @Transactional
    public void register(SignupRequestDTO request){
        User savedUser = userService.register(request.user());

        if (request.role() == Tipologia.AUTORE) {
            Autore autore = request.autore();
            autore.setUser(savedUser);
            autoreService.addAutore(autore);
        }
        if (request.role() == Tipologia.LETTORE) {
            Lettore lettore = request.lettore();
            lettore.setUser(savedUser);
            lettoreService.addLettore(lettore);
        }
    }
}
