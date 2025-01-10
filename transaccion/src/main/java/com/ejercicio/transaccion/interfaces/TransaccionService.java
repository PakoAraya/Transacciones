package com.ejercicio.transaccion.interfaces;

import com.ejercicio.transaccion.model.Transaccion;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
  List<Transaccion> getAllTransacciones();
  Optional<Transaccion>getAllTransaccionesById(Long id);
  Transaccion saveTransaccion(Transaccion transaccion);
  Transaccion updateEstado(Long id, boolean estado);
}
