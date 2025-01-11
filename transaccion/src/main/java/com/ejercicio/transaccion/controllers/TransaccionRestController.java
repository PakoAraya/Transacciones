package com.ejercicio.transaccion.controllers;

import com.ejercicio.transaccion.dtos.TransaccionDTO;
import com.ejercicio.transaccion.interfaces.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionRestController {

  @Autowired
  private TransaccionService transaccionService;

  // Obtener todas las transacciones
  @GetMapping
  public List<TransaccionDTO> getAllTransacciones() {
    return transaccionService.getAllTransacciones();
  }

  // Obtener una transacción por id
  @GetMapping("/{id}")
  public ResponseEntity<TransaccionDTO> getTransaccionById(@PathVariable Long id) {
    Optional<TransaccionDTO> transaccionDTO = transaccionService.getTransaccionById(id);
    if (transaccionDTO.isPresent()) {
      return ResponseEntity.ok(transaccionDTO.get());
    } else {
      return ResponseEntity.notFound().build();  // Si no se encuentra, devolvemos 404
    }
  }

  // Guardar una nueva transacción
  @PostMapping
  public ResponseEntity<TransaccionDTO> saveTransaccion(@RequestBody TransaccionDTO transaccionDTO) {
    TransaccionDTO savedTransaccion = transaccionService.saveTransaccion(transaccionDTO);
    return ResponseEntity.ok(savedTransaccion);
  }

  // Actualizar el estado de una transacción
  @PutMapping("/{id}")
  public ResponseEntity<TransaccionDTO> updateTransaccion(@PathVariable Long id, @RequestBody TransaccionDTO transaccionDTO) {
    try {
      // Aquí llamamos a un servicio para actualizar la transacción completa
      TransaccionDTO updatedTransaccion = transaccionService.updateTransaccion(id, transaccionDTO);
      return ResponseEntity.ok(updatedTransaccion);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();  // Si no se encuentra, devolvemos 404
    }
  }

  //Eliminar una transaccion por id
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
    try {
      transaccionService.deleteTransaccion(id);  // Llamar al servicio para eliminar
      return ResponseEntity.noContent().build();  // Responder con 204 No Content
    } catch (RuntimeException e) {
      // Si la transacción no se encuentra, devolvemos 404
      return ResponseEntity.notFound().build();
    }
  }
}
