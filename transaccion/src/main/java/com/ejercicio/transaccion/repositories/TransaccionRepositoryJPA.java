
package com.ejercicio.transaccion.repositories;

import com.ejercicio.transaccion.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepositoryJPA extends JpaRepository<Transaccion, Long> {
  //Aqui vamos a agregar las consultas personalizadas que se requieran.

}