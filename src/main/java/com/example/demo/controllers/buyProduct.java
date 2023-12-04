package com.example.demo.controllers;


import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.repositories.ProductRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class buyProduct {

    private PartService partService;
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    public buyProduct(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    };

    @PostMapping("/buyProduct")
    public String buyTheProduct(@RequestParam("productID") Long productID, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productRepository.findById(productID);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                redirectAttributes.addFlashAttribute("successMessage", "Purchase successful!");
                return "redirect:/purchaseSuccess";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Product out of stock!");
                return "redirect:/purchaseError";
            }
        }
        redirectAttributes.addFlashAttribute("errorMessage", "Product not found!");
        return "redirect:/purchaseError";
    }

    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess";
    };

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError";
    };
}
