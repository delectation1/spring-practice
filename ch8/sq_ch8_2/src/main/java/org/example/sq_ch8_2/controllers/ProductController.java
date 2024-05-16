package org.example.sq_ch8_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.example.sq_ch8_2.services.ProductService;
import org.example.sq_ch8_2.model.Product;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products") // maps HTTP get requests with specific path to controller's action
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "products";
    }

    /* @RequestMapping(path = "/products", use this if u dont use PostMapping (not best practice)
                    method = RequestMethod.POST) */
    @PostMapping("/products") // post means use html form
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            // Product p
            Model model) {
        // possible to omit this entirely, as SPring knows to create instance from request attributes
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);

        return "products";
    }
}