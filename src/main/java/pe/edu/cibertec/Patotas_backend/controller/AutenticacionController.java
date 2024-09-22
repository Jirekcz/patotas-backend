package pe.edu.cibertec.Patotas_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Patotas_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.Patotas_backend.dto.LoginResponseDTO;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {

        return new LoginResponseDTO("00", "", "Jireh Flores", "jireh03@gmail.com");

    }

}
