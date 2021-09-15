package controller;

import model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class PersonasController {
	@Autowired
	RestTemplate template;
	@Autowired
	FeignServiceGet cliente1;
	@Autowired
	FeignServiceCreate cliente2;
	@Autowired
	FeignServiceDelete cliente3;
	@Autowired
	FeignServiceModify cliente4;
	String url="http://service-get";

	//Normal Request
	@GetMapping(value="/clientes2", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> getclientes(){
		Cliente[] clientes=template.getForObject(url+"/clientes", Cliente[].class);
		return Arrays.asList(clientes);
	}
	//Feign Request
	@GetMapping(value="/clientes",produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Cliente>> recuperarClientes(){
		return (cliente1.recuperarClientes());
	}

	@GetMapping(value="clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	Cliente getClientId(@PathVariable("id") int id){
		return cliente1.getClientId(id);
	}
	@GetMapping(value="/clientes/mayores/{age}",produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> recuperarClientesMayores(@PathVariable("age") int edad) {
		return cliente1.recuperarClientesMayores(edad);
	}
	//save
	@PostMapping(value="/clientes",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String guardarCliente(@RequestBody Cliente cliente){
		return cliente2.saveClient(cliente);
	}

	@PostMapping("/photos/add")
	public String AgregarFoto(@RequestParam("title") int title, @RequestParam("image") MultipartFile image, Model model) throws IOException {
		return cliente2.addPhoto(title, image, model);
	}
	@DeleteMapping(value="/clientes/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public String BorrarClienteId(@PathVariable("id") int id){
		return cliente3.BorrarClienteId(id);
	}
	@DeleteMapping("/photos/{title}")
	public String BorrarfotoId(@PathVariable int title){
		return cliente3.BorrarfotoId(title);
	}
	@PutMapping(value="clientes/actualizar/",consumes= MediaType.APPLICATION_JSON_VALUE)
	public String actualizarContacto(@RequestBody Cliente contacto){
		return cliente4.actualizarContacto(contacto);
	}
	@PutMapping(value = "/photos/update" )
	public String actualizarFoto(@RequestParam("title") int title, @RequestParam("image") MultipartFile image, Model model) throws IOException{
		return cliente4.actualizarFoto(title, image, model);
	}



}
