package com.ejercicio.transaccion.services;

import com.ejercicio.transaccion.interfaces.TransaccionService;
import com.ejercicio.transaccion.model.Transaccion;
import com.ejercicio.transaccion.repositories.TransaccionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {
  //Aqui vamos a implementar los metodo de la interface TransaccionService con las funciones JPA por defectos

  @Autowired
  private TransaccionRepositoryJPA transaccionRepositoryJPA;

  @Override
  public List<Transaccion> getAllTransacciones() {
    return transaccionRepositoryJPA.findAll();
  }

  @Override
  public Optional<Transaccion> getAllTransaccionesById(Long id) {
    return transaccionRepositoryJPA.findById(id);
  }

  @Override
  public Transaccion saveTransaccion(Transaccion transaccion) {
    return transaccionRepositoryJPA.save(transaccion);
  }

  @Override
  public Transaccion updateEstado(Long id, boolean estado) {
    Optional<Transaccion> transaccionOpt = transaccionRepositoryJPA.findById(id);
    if (transaccionOpt.isPresent()) {
      Transaccion transaccion = transaccionOpt.get();
      transaccion.setEstado(estado);
      return transaccionRepositoryJPA.save(transaccion);
    }
    return null;
  }


}
