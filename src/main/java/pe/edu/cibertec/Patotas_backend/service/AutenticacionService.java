package pe.edu.cibertec.Patotas_backend.service;

import pe.edu.cibertec.Patotas_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.Patotas_backend.dto.LogoutRequestDTO;

import java.io.IOException;
import java.util.Date;

public interface AutenticacionService {

    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;
    Date cerrarSesion(LogoutRequestDTO logoutRequestDTO) throws IOException;
}
