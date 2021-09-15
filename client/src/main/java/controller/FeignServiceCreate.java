package controller;

import feign.Headers;
import feign.RequestLine;
import inicio.FeignConfiguration;
import model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FeignClient(name = "service-create", configuration = FeignConfiguration.class)
public interface FeignServiceCreate {

    //Save client
    @PostMapping(value="/clientes",consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
    String saveClient(@RequestBody Cliente cliente);

    //Save photo
    @Headers("Content-Type: multipart/form-data")
    @PostMapping(value = "/photos/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String addPhoto(@RequestParam("title") int title, @RequestParam("image") MultipartFile image, Model model) throws IOException;



}