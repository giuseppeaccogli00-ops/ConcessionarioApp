package com.example.bff.clients;

import com.example.bff.dto.request.VenditoreRequest;
import com.example.bff.dto.response.VenditoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "application-venditore-client",
        url = "http://localhost:8081"
)
public interface VenditoreClient {

    @PostMapping("/venditores")
    VenditoreResponse create(
            @RequestBody VenditoreRequest request
    );

    @PostMapping("venditores/random")
    void venditoriRandom();

    @GetMapping("/venditores")
    List<VenditoreResponse> getAll();

    @GetMapping("/venditores/{id}")
    VenditoreResponse getById(
            @PathVariable Integer id
    );

    @DeleteMapping("/venditores/{id}")
    void delete(
            @PathVariable Integer id
    );
}

