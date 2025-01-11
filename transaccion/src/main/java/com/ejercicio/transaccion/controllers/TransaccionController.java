package com.ejercicio.transaccion.controllers;

import com.ejercicio.transaccion.dtos.TransaccionDTO;
import com.ejercicio.transaccion.interfaces.TransaccionService;
import com.ejercicio.transaccion.services.TransaccionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransaccionController {

  @Autowired
  private TransaccionServiceImpl transaccionServiceImpl;

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("transacciones", transaccionServiceImpl.getAllTransacciones());
    return "index";
  }

  //Controller para cambiar el estado
  @PostMapping("/transaccion/{id}/cambiarEstado")
  public String cambiarEstado(@PathVariable Long id, Model model){
    TransaccionDTO transaccionDTO = transaccionServiceImpl.getTransaccionById(id).orElse(null);
    if(transaccionDTO != null){
      transaccionServiceImpl.updateEstado(id, !transaccionDTO.isEstado());
    }
    return "redirect:/";
  }
}
