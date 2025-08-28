package com.example.hexapp.application.rest;

import com.example.hexapp.application.dto.PriceDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RequestMapping("/prices")
public interface PriceController {

    @GetMapping("/apply")
    PriceDTO priceApply(@RequestParam Long brandId,
                        @RequestParam Long productId,
                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime applicationDate)
            throws NoSuchElementException;

}
