package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sena.crud_basic.dto.movieDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.service.movieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class movieController {

    /*
     * POST
     * GET
     * GET:id
     * PUT
     * DELETE
     */

    @Autowired
    private movieService movieService;

    // POST - Registrar una nueva película
    @PostMapping("/")
    public ResponseEntity<Object> registerMovie(@RequestBody movieDTO movie) {
        responseDTO respuesta = movieService.save(movie);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET - Obtener todas las películas
    @GetMapping("/")
    public ResponseEntity<Object> getAllMovies() {
        var listaMovies = movieService.findAll();
        return new ResponseEntity<>(listaMovies, HttpStatus.OK);
    }

    // GET:id - Obtener una película por su ID
    @GetMapping("/{idMovie}")
    public ResponseEntity<Object> getOneMovie(@PathVariable int idMovie) {
        var movie = movieService.findById(idMovie);
        if (!movie.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    // PUT - Actualizar película por ID
    @PutMapping("/{idMovie}")
    public ResponseEntity<Object> updateMovie(@PathVariable int idMovie, @RequestBody movieDTO movie) {
        responseDTO respuesta = movieService.updateMovie(idMovie, movie);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // DELETE - Eliminar película por ID
    @DeleteMapping("/{idMovie}")
    public ResponseEntity<Object> deleteMovie(@PathVariable int idMovie) {
        responseDTO message = movieService.deleteMovie(idMovie);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
