package com.upiiz.layers.categorias.dto;

public class NuevaCategoriaDto {

    private String descripcion;

    // 1. Constructor vacío (Estrictamente necesario para Jackson/Spring)
    public NuevaCategoriaDto() {
    }

    // 2. Constructor con parámetros
    public NuevaCategoriaDto(String descripcion) {
        this.descripcion = descripcion;
    }

    // 3. Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}