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
    @GetMapping(value="/clientes",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> recuperarClientes() {
        return ResponseEntity.ok(servicio.recuperarClientes());
    }
    @GetMapping(value="clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public Cliente recuperarClientes(@PathVariable("id") int id) {
        return servicio.buscarCliente(id);
    }
    @GetMapping(value="/clientes/mayores/{age}",produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> recuperarClientesMayores(@PathVariable("age") int edad) {
        return servicio.ClientesMayores(edad);
    }


    //Images MongoDB

    @GetMapping("/photos/{Mongoid}")//imagen by MongoId
    public String getPhoto(@PathVariable String Mongoid) {
        try {
            Photo photo = photoService.getPhoto(Mongoid);
            return Base64.getEncoder().encodeToString(photo.getImage().getData());
        }catch (NoSuchElementException e){
            return "La foto con Mongo id"+Mongoid+" no fue encontrada";
        }
    }


    @GetMapping("/photo/{title}")
    public String getPhotoid(@PathVariable int title) {
        Photo photo = photoService.getPhotoByTitle(title);
        System.out.println("hola");
        if (photo==null){
            return "La imagen con id "+ title +" no fue encontrada";
        }
        else{
            return  Base64.getEncoder().encodeToString(photo.getImage().getData());
        }
    }



}
