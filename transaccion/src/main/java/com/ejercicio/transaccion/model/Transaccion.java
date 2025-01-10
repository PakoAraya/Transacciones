package com.ejercicio.transaccion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transacciones")
public class Transaccion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "descripcion", nullable = false)
  private String descripcion;

  @Column(name = "monto", nullable = false)
  private Double monto;

  @Column(name = "tipo", nullable = false)
  private String tipo;

  @Column(name = "estado", nullable = false)
  private boolean estado = false;

  public Transaccion() {
  }

  public Transaccion(Long id, String descripcion, Double monto, String tipo, boolean estado) {
    this.id = id;
    this.descripcion = descripcion;
    this.monto = monto;
    this.tipo = tipo;
    this.estado = estado;
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
