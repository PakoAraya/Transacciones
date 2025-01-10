package com.ejercicio.transaccion.services;

import com.ejercicio.transaccion.interfaces.TransaccionService;
import com.ejercicio.transaccion.model.Transaccion;

import java.util.List;
import java.util.Optional;

public class TransaccionServiceImpl implements TransaccionService {
  //Aqui vamos a implementar los metodo de la interface TransaccionService con las funciones JPA por defectos

  @Override
  public List<Transaccion> getAllTransacciones() {
    return List.of();
  }

  @Override
  public Optional<Transaccion> getAllTransaccionesById(Long id) {
    return Optional.empty();
  }

  @Override
  public Transaccion saveTransaccion(Transaccion transaccion) {
    return null;
  }

  @Override
  public Transaccion updateEstado(Long id, boolean estado) {
    return null;
  }


}
