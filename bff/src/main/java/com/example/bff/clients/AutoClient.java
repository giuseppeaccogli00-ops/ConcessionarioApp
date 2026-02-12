package com.example.bff.clients;

import com.example.bff.dto.request.AutoRequest;
import com.example.bff.dto.response.AutoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "application-auto-client", url = "http://localhost:8081")
public interface AutoClient {

    @PostMapping("/macchinas")
    AutoResponse create(@RequestBody AutoRequest request);

    @GetMapping("/macchinas")
    List<AutoResponse> getAll();

    @GetMapping("/macchinas/{id}")
    AutoResponse getById(@PathVariable Integer id);

    @DeleteMapping("/macchinas/{id}")
    void delete(@PathVariable Integer id);
}

