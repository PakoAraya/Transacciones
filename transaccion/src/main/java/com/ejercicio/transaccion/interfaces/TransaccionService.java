package com.ejercicio.transaccion.interfaces;

import com.ejercicio.transaccion.dtos.TransaccionDTO;

import java.util.List;
import java.util.Optional;

public interface TransaccionService {
  List<TransaccionDTO> getAllTransacciones();  // Para obtener todas las transacciones
  Optional<TransaccionDTO> getTransaccionById(Long id);  // Usamos Optional para manejar el caso de "no encontrado"
  TransaccionDTO saveTransaccion(TransaccionDTO transaccionDTO);  // Guardar una nueva transacción
  TransaccionDTO updateEstado(Long id, boolean estado);  // Actualizar estado de la transacción
  TransaccionDTO updateTransaccion(Long id, TransaccionDTO transaccionDTO); //Actualiza todos los datos de transaccion
  void deleteTransaccion(Long id); //Metodo para eliminar una transaccion
}