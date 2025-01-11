package com.ejercicio.transaccion.services;

import com.ejercicio.transaccion.dtos.TransaccionDTO;
import com.ejercicio.transaccion.interfaces.TransaccionService;
import com.ejercicio.transaccion.model.Transaccion;
import com.ejercicio.transaccion.repositories.TransaccionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransaccionServiceImpl implements TransaccionService {

  @Autowired
  private TransaccionRepositoryJPA transaccionRepositoryJPA;

  // Devuelve todas las transacciones como lista de DTOs
  @Override
  public List<TransaccionDTO> getAllTransacciones() {
    List<Transaccion> transacciones = transaccionRepositoryJPA.findAll();
    return transacciones.stream()
            .map(transaccion -> new TransaccionDTO(transaccion)) // Mapeo entidad -> DTO
            .collect(Collectors.toList());
  }

  // Devuelve una transacción específica por id. Si no existe, lanza una excepción.
  @Override
  public Optional<TransaccionDTO> getTransaccionById(Long id) {
    Optional<Transaccion> transaccionOpt = transaccionRepositoryJPA.findById(id);
    if (transaccionOpt.isPresent()) {
      // Si la transacción existe, la convertimos en un DTO y la devolvemos
      return Optional.of(new TransaccionDTO(transaccionOpt.get()));
    }
    // Si no existe, devolvemos un Optional vacío
    return Optional.empty();
  }

  // Guardar una nueva transacción y devolver su DTO
  @Override
  public TransaccionDTO saveTransaccion(TransaccionDTO transaccionDTO) {
    // Convertir el DTO en la entidad
    Transaccion transaccion = new Transaccion();
    transaccion.setDescripcion(transaccionDTO.getDescripcion());
    transaccion.setMonto(transaccionDTO.getMonto());
    transaccion.setTipo(transaccionDTO.getTipo());
    transaccion.setEstado(transaccionDTO.isEstado());

    // Guardar la transacción en la base de datos
    transaccion = transaccionRepositoryJPA.save(transaccion);

    // Retornar el DTO de la transacción guardada
    return new TransaccionDTO(transaccion);
  }

  // Actualiza el estado de una transacción y devuelve su DTO actualizado
  @Override
  public TransaccionDTO updateEstado(Long id, boolean estado) {
    // Buscar la transacción por id
    Optional<Transaccion> transaccionOpt = transaccionRepositoryJPA.findById(id);
    if (transaccionOpt.isPresent()) {
      Transaccion transaccion = transaccionOpt.get();
      transaccion.setEstado(estado);

      // Guardar la transacción con el nuevo estado
      transaccion = transaccionRepositoryJPA.save(transaccion);

      // Retornar el DTO con el estado actualizado
      return new TransaccionDTO(transaccion);
    }

    // Si no se encuentra la transacción, lanzar una excepción
    throw new RuntimeException("Transacción no encontrada con el id: " + id);
  }

  @Override
  public TransaccionDTO updateTransaccion(Long id, TransaccionDTO transaccionDTO) {
    Optional<Transaccion> transaccionOptional = transaccionRepositoryJPA.findById(id);
    if (transaccionOptional.isPresent()) {
      Transaccion transaccion = transaccionOptional.get();
      transaccion.setDescripcion(transaccionDTO.getDescripcion());
      transaccion.setMonto(transaccionDTO.getMonto());
      transaccion.setTipo(transaccionDTO.getTipo());
      transaccion.setEstado(transaccionDTO.isEstado());
      transaccionRepositoryJPA.save(transaccion);
      return new TransaccionDTO(transaccion);
    } else {
      throw new RuntimeException("Transacción no encontrada");
    }
  }

  //Metodo para eliminar registros de la base de datos
  @Override
  public void deleteTransaccion(Long id) {
    // Verificar si la transacción existe
    Optional<Transaccion> transaccionOpt = transaccionRepositoryJPA.findById(id);
    if (transaccionOpt.isPresent()) {
      // Si existe, eliminar la transacción
      transaccionRepositoryJPA.deleteById(id);
    } else {
      // Si no se encuentra, lanzar una excepción (puedes manejarla como desees)
      throw new RuntimeException("Transacción no encontrada con el id: " + id);
    }
  }
}