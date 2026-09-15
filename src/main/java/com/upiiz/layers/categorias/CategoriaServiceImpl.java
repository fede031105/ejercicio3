package com.upiiz.layers.categorias;

import com.upiiz.layers.categorias.dto.CategoriaDto;
import com.upiiz.layers.categorias.dto.NuevaCategoriaDto;
import com.upiiz.layers.categorias.entities.CategoriaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDto save(NuevaCategoriaDto nuevaCategoriaDto) {
        // Validar si ya existe por descripción usando el método de CategoriaRepository
        Optional<CategoriaEntity> categoriaExistente = categoriaRepository
                .findByDescripcionIgnoreCase(nuevaCategoriaDto.getDescripcion());

        if (categoriaExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una categoría con la descripción: " + nuevaCategoriaDto.getDescripcion());
        }

        // Mapeo de DTO de entrada a Entidad
        CategoriaEntity entity = new CategoriaEntity();
        entity.setDescripcion(nuevaCategoriaDto.getDescripcion());

        // Guardar en la base de datos
        CategoriaEntity guardada = categoriaRepository.save(entity);

        // Mapeo de Entidad a DTO de salida
        CategoriaDto respuesta = new CategoriaDto();
        respuesta.setId(guardada.getId());
        respuesta.setDescripcion(guardada.getDescripcion());

        return respuesta;
    }

    @Override
    public List<CategoriaDto> findAll() {
        throw new UnsupportedOperationException("Operación no implementada aún");
    }

    @Override
    public CategoriaDto update(Long id, NuevaCategoriaDto updateCategoriaDto) {
        throw new UnsupportedOperationException("Operación no implementada aún");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Operación no implementada aún");
    }
}