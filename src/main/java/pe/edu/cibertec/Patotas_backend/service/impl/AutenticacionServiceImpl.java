package pe.edu.cibertec.Patotas_backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.Patotas_backend.dto.LoginRequestDTO;
import pe.edu.cibertec.Patotas_backend.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException {
        String[] datosUsuario = null;
        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (loginRequestDTO.tipoDocumento().equals(datos[0]) && loginRequestDTO.numeroDocumento().equals(datos[1]) && loginRequestDTO.password().equals(datos[2])) {
                    datosUsuario = new String[2];
                    datosUsuario[0] = datos[3];  // Recuperando el nombre del usuario
                    datosUsuario[1] = datos[4];  // Recuperando el email del usuario
                }
            }

        } catch (IOException e) {
            throw new IOException(e);
        }

        return datosUsuario;
    }
}
