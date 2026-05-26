package com.example.libreria.DTO;

import com.example.libreria.entity.Autore;
import com.example.libreria.entity.Lettore;
import com.example.libreria.entity.User;
import com.example.libreria.enums.Tipologia;

public record SignupRequestDTO (User user,
                                Lettore lettore,
                                Autore autore,
                                Tipologia role){

}
