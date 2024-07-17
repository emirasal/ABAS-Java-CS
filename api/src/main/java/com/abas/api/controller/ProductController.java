package com.abas.api.controller;

import com.abas.API.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private List<Product> data = new ArrayList<>();

    @GetMapping("/products")
    public ResponseEntity<String> getProducts() {
        StringBuilder response = new StringBuilder("Tüm Veriler: \n");
        for (Product product : data) {
            response.append("Sipariş: ").append(product.getSiparis()).append(", Mal Numarası: ").append(product.getMalNumarasi()).append(", Miktar: ").append(product.getMiktar()).append(", Birim Fiyat: ").append(product.getBirimFiyat()).append("\n");
        }
        return ResponseEntity.ok(response.toString());
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        data.add(product);
        String response = "Ürün Kayıt Edildi: \nSipariş: " + product.getSiparis() + ", Mal Numarası: " + product.getMalNumarasi() + ", Miktar: " + product.getMiktar() + ", Birim Fiyat: " + product.getBirimFiyat();
        return ResponseEntity.ok(response);
    }
}