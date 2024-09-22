package pe.edu.cibertec.Patotas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.Patotas_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.Patotas_backend.dto.LoginResponseDTO;
import pe.edu.cibertec.Patotas_backend.service.AutenticacionService;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {

        try {
            String[] datosUsuario = autenticacionService.validarUsuario(loginRequestDTO);
            if (datosUsuario == null) {
                return new LoginResponseDTO("01", "ERROR: Usuario no encontrado", "", "");
            } else {
                return new LoginResponseDTO("00", "", datosUsuario[0], datosUsuario[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new LoginResponseDTO("99", "ERRO: Ocurrio un problema", "", "");
        }

    }

}
