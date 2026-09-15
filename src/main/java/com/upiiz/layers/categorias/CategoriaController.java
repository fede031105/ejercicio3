package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.CategoriaDto;
import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Único endpoint activo para AGREGAR
    @PostMapping
    public ResponseEntity<CategoriaDto> agregarCategoria(@RequestBody NuevaCategoriaDto nuevaCategoriaDto) {
        CategoriaDto categoriaGuardada = categoriaService.save(nuevaCategoriaDto);
        return new ResponseEntity<>(categoriaGuardada, HttpStatus.CREATED);
    }
}