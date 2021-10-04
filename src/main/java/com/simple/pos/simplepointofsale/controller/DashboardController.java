package com.simple.pos.simplepointofsale.controller;
  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping("/customer")
    public String viewCustomerDashboard(Model model){


        return "dashboard/customer";
    }
}
