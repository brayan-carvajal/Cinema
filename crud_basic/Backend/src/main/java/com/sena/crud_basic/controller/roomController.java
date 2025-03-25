package com.sena.crud_basic.controller;

import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.dto.roomDTO;
import com.sena.crud_basic.service.roomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
public class roomController {

    /*
     * POST
     * GET
     * PUT
     * DELETE
     */

    @Autowired
    private roomService roomService;

    // POST - Registrar una sala
    @PostMapping("/post")
    public ResponseEntity<Object> registerRoom(@RequestBody roomDTO room) {
        responseDTO respuesta = roomService.save(room);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET - Obtener todas las salas
    @GetMapping("/get")
    public ResponseEntity<Object> getAllRooms() {
        var listaRooms = roomService.findAll();
        return new ResponseEntity<>(listaRooms, HttpStatus.OK);
    }

    // GET:id - Obtener una sala por ID
    @GetMapping("/{idRoom}")
    public ResponseEntity<Object> getOneRoom(@PathVariable int idRoom) {
        var room = roomService.findById(idRoom);
        if (!room.isPresent()) {
            return new ResponseEntity<>(
                    new responseDTO(HttpStatus.NOT_FOUND.toString(), "Sala no encontrada"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    // DELETE - Eliminar una sala
    @DeleteMapping("/{idRoom}")
    public ResponseEntity<Object> deleteRoom(@PathVariable int idRoom) {
        responseDTO respuesta = roomService.deleteRoom(idRoom);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // PUT - Actualizar una sala
    @PutMapping("/{idRoom}")
    public ResponseEntity<Object> updateRoom(@PathVariable int idRoom, @RequestBody roomDTO room) {
        responseDTO respuesta = roomService.updateRoom(idRoom, room);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
