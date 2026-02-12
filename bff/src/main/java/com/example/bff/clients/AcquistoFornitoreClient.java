package com.example.bff.clients;

import com.example.bff.dto.request.AcquistoFornitoreRequest;
import com.example.bff.dto.response.AcquistoFornitoreResponse;
import org.springframework.cloud.openfeign.FeignClient;//mi permette di richiamare un altro microservizio, genera in automatico una chiamata HTTP all'altro microservizio
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "application-AcquistoFornitore-client",
        url = "http://localhost:8081"
)
public interface AcquistoFornitoreClient {

    @PostMapping("/autos")
    AcquistoFornitoreResponse create(
            @RequestBody AcquistoFornitoreRequest request
    );

    @GetMapping("/autos")
    List<AcquistoFornitoreResponse> getAll();

    @GetMapping("/autos/{id}")
    AcquistoFornitoreResponse getById(
            @PathVariable Integer id
    );

    @DeleteMapping("/autos/{id}")
    void delete(
            @PathVariable Integer id
    );
}

