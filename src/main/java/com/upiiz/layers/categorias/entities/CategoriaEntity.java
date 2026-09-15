package com.upiiz.layers.categorias.entities;

import jakarta.persistence.*;

// Capa de Base de Datos - ORM
@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descripcion;

    public CategoriaEntity() {
    }

    public CategoriaEntity(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriaEntity(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
}