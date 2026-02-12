package com.example.bff.clients;

import com.example.bff.dto.request.FornitoreRequest;
import com.example.bff.dto.response.FornitoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "application-fornitore-client", url = "http://localhost:8081")
public interface FornitoreClient {

    @PostMapping("/fornitores")
    FornitoreResponse create(@RequestBody FornitoreRequest request);

    @GetMapping("/fornitores")
    List<FornitoreResponse> getAll();
}

