package com.example.bff.clients;

import com.example.bff.dto.response.VenditeVenditoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "application-service-venditeVenditore", url = "http://localhost:8081")
public interface VenditeVenditoreClient {

    @GetMapping("/reports")
    List<VenditeVenditoreResponse> getReport(
            @RequestParam("start") String start,
            @RequestParam("end") String end
    );
}

