package controller;

import inicio.FeignConfiguration;
import model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "service-get", configuration = FeignConfiguration.class)
public interface FeignServiceGet {
    @GetMapping(value="/clientes",produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Cliente>> recuperarClientes();

    @GetMapping(value="clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    Cliente getClientId(@PathVariable("id") int id);
    @GetMapping(value="/clientes/mayores/{age}",produces= MediaType.APPLICATION_JSON_VALUE)
    List<Cliente> recuperarClientesMayores(@PathVariable("age") int edad);
}
