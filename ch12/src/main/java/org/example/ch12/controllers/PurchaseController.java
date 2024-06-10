package org.example.ch12.controllers;

import org.example.ch12.model.Purchase;
import org.example.ch12.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping("/purchase")
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping("/purchase")
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}