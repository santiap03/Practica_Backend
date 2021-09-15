package Controller;

import Model.Cliente;
import Model.Photo;
import Service.DataService;
import Service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
public class controlador {
    @Autowired
    DataService servicio;
    @Autowired
    PhotoService photoService;
    @DeleteMapping("/photos/{title}")
    public String BorrarfotoId(@PathVariable int title) {
        boolean check = photoService.DeleteByTitle(title);
        if (check){
            return "Se borro la imagen con id "+ title ;
        }
        else{
            return "No existe la imagen";
        }
    }

    @DeleteMapping(value="/clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public String BorrarClienteId(@PathVariable("id") int id) {
        boolean a =servicio.eliminarCliente(id);
        if (a){
            return  "Cliente borrado";

        }
        else {
            return "No existe el cliente";
        }
    }



}
