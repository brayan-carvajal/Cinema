package com.sena.crud_basic.controller;

import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.dto.screeningDTO;
import com.sena.crud_basic.service.screeningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/screening")
public class screeningController {

    /*
     * POST
     * GET
     * PUT
     * DELETE
     */

    @Autowired
    private screeningService screeningService;

    // POST - Registrar una nueva proyección
    @PostMapping("/post")
    public ResponseEntity<Object> registerScreening(@RequestBody screeningDTO screening) {
        responseDTO respuesta = screeningService.save(screening);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET - Obtener todas las proyecciones
    @GetMapping("/get")
    public ResponseEntity<Object> getAllScreenings() {
        var listaScreenings = screeningService.findAll();
        return new ResponseEntity<>(listaScreenings, HttpStatus.OK);
    }

    // GET:id - Obtener una proyección específica
    @GetMapping("/{idScreening}")
    public ResponseEntity<Object> getOneScreening(@PathVariable int idScreening) {
        var screening = screeningService.findById(idScreening);
        if (!screening.isPresent())
            return new ResponseEntity<>("Proyección no encontrada", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(screening, HttpStatus.OK);
    }

    // DELETE - Eliminar una proyección por ID
    @DeleteMapping("/{idScreening}")
    public ResponseEntity<Object> deleteScreening(@PathVariable int idScreening) {
        var message = screeningService.deleteScreening(idScreening);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // PUT - Actualizar una proyección
    @PutMapping("/{idScreening}")
    public ResponseEntity<Object> updateScreening(@PathVariable int idScreening, @RequestBody screeningDTO screening) {
        responseDTO respuesta = screeningService.updateScreening(idScreening, screening);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
