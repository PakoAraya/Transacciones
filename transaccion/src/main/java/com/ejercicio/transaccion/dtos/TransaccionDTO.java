package com.ejercicio.transaccion.dtos;

import com.ejercicio.transaccion.model.Transaccion;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TransaccionDTO {
  @NotNull(message = "El id no puede ser nulo")
  private Long id;

  @NotNull(message = "Debe escribir alguna descripcion")
  @Size(min = 4, message = "Entregue una descripcion descriptiva")
  private String descripcion;

  @NotNull(message = "Debe ingresar un valor positivo")
  private Double monto;

  @NotNull(message = "Debe ingresar alguna descripcion")
  private String tipo;

  private boolean estado = false;

  public TransaccionDTO(){
  }

  // Constructor de DTO con parámetros
  public TransaccionDTO(Long id, String descripcion, Double monto, String tipo, boolean estado) {
    this.id = id;
    this.descripcion = descripcion;
    this.monto = monto;
    this.tipo = tipo;
    this.estado = estado;
  }

  // Constructor que mapea desde una entidad Transaccion
  public TransaccionDTO(Transaccion transaccion) {
    this.id = transaccion.getId();
    this.descripcion = transaccion.getDescripcion();
    this.monto = transaccion.getMonto();
    this.tipo = transaccion.getTipo();
    this.estado = transaccion.isEstado();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public boolean isEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }
}