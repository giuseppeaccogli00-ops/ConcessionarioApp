package com.example.bff.clients;

import com.example.bff.dto.request.VenditaRequest;
import com.example.bff.dto.response.VenditaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "application-vendita-client", url = "http://localhost:8081")
public interface VenditaClient {

    @PostMapping("/venditas")
    VenditaResponse create(@RequestBody VenditaRequest request);

    @PostMapping("venditas/random")
    void venditeRandom();

    @GetMapping("/venditas")
    List<VenditaResponse> getAll();
}

