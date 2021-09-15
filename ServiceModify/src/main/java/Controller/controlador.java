package Controller;

import Model.Cliente;
import Service.DataService;
import Service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
public class controlador {
    @Autowired
    DataService servicio;
    @Autowired
    PhotoService photoService;

    @PutMapping(value="clientes/actualizar/",consumes=MediaType.APPLICATION_JSON_VALUE)
    public String actualizarContacto(@RequestBody Cliente contacto) {
        servicio.actualizarCliente(contacto);
        return "Cliente actualizado o creado";
    }


    //Images MongoDB

    @PutMapping("/photos/update")
    public String actualizarFoto(@RequestParam("title") int title, @RequestParam("image") MultipartFile image, Model model) throws IOException {

        return photoService.updatePhoto(title, image);
    }


}
