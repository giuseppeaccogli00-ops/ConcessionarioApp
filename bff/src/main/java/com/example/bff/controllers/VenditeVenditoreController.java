package com.example.bff.controllers;



import com.example.bff.clients.VenditeVenditoreClient;
import com.example.bff.dto.response.VenditeVenditoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class VenditeVenditoreController {

    private final VenditeVenditoreClient service;

    @GetMapping
    public List<VenditeVenditoreResponse> getReport(
            @RequestParam String start,
            @RequestParam String end) {

        return service.getReport(start, end);
    }

}


