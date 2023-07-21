package com.example.warehouse.controller;

import com.example.warehouse.repository.CurrencyRepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.repository.SupplierRepository;
import com.example.warehouse.repository.WarehouseRepository;
import com.example.warehouse.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    final ProductRepository productRepository;
    final SupplierRepository supplierRepository;
    final WarehouseRepository warehouseRepository;
    final CurrencyRepository currencyRepository;
    final AuthService authService;

    @GetMapping
    public String homePage(HttpServletRequest req){
        if (authService.checkToken(authService.getToken(req.getCookies()))) {
            return "redirect:/dashboard/most-sold";
        }
        return "redirect:/auth/login";
    }

    @GetMapping(path = "/favicon.ico")
    public void favicon(HttpServletResponse response){
        response.setStatus(302);
        response.setHeader("Location", "/assets/favicon.ico");
    }
}
