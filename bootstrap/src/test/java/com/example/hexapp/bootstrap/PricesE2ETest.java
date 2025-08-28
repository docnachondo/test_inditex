package com.example.hexapp.bootstrap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    @Test
    void apply_endpoint_works() {
        String url = "http://localhost:" + port + "/prices/apply?brandId=1&productId=35455&applicationDate=2020-06-14T16:00:00";
        ResponseEntity<String> resp = rest.getForEntity(url, String.class);
        assertEquals(200, resp.getStatusCodeValue());
        assertTrue(resp.getBody().contains("\"curr\":\"EUR\""));
    }
}
