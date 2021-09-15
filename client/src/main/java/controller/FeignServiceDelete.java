package controller;


import inicio.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-delete", configuration = FeignConfiguration.class)

public interface FeignServiceDelete {
    @DeleteMapping(value="/clientes/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    String BorrarClienteId(@PathVariable("id") int id);

    @DeleteMapping("/photos/{title}")
    public String BorrarfotoId(@PathVariable int title);

}
