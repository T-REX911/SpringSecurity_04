package com.spring.SpringSecurity_04.SpringSecurity_04.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/create")
    public String createProduct() {
        return "Product created";
    }

    @GetMapping("/read")
    public String readProduct() {
        return "Product details";
    }

    @GetMapping("/header")
    public String readHeader(@RequestHeader("header") String header) {
        return "Header : " + header;
    }

    @PutMapping("/update")
    public String updateProduct() {
        return "Product updated";
    }

    @DeleteMapping("/delete")
    public String deleteProduct() {
        return "Product deleted";
    }
}
