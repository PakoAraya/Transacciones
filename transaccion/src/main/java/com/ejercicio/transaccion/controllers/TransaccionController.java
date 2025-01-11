package com.ejercicio.transaccion.controllers;

import com.ejercicio.transaccion.interfaces.TransaccionService;
import com.ejercicio.transaccion.services.TransaccionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransaccionController {

  @Autowired
  private TransaccionService transaccionService;
  @Autowired
  private TransaccionServiceImpl transaccionServiceImpl;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("transacciones", transaccionServiceImpl.getAllTransacciones());
    return "index";
  }
}
