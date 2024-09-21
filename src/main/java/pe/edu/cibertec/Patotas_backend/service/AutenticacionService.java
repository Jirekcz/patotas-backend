package pe.edu.cibertec.Patotas_backend.service;

import pe.edu.cibertec.Patotas_backend.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;

}
