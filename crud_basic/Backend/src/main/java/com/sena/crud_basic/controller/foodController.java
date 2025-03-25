package com.sena.crud_basic.controller;

import org.springframework.web.bind.annotation.RestController;
import com.sena.crud_basic.dto.foodDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.service.foodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food")
public class foodController {

    /*
     * POST
     * GET
     * PUT
     * DELETE
     */

    @Autowired
    private foodService foodService;

    // POST
    @PostMapping("/post")
    public ResponseEntity<Object> registerFood(@RequestBody foodDTO food) {
        responseDTO respuesta = foodService.save(food);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET
    @GetMapping("/get")
    public ResponseEntity<Object> getAllFood() {
        var listaFood = foodService.findAll();
        return new ResponseEntity<>(listaFood, HttpStatus.OK);
    }

    // GET:id
    @GetMapping("/{idFood}")
    public ResponseEntity<Object> getOneFood(@PathVariable int idFood) {
        var food = foodService.findById(idFood);
        if (!food.isPresent())
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{idFood}")
    public ResponseEntity<Object> deleteFood(@PathVariable int idFood) {
        var message = foodService.deleteFood(idFood);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // PUT
    @PutMapping("/{idFood}")
    public ResponseEntity<Object> updateFood(@PathVariable int idFood, @RequestBody foodDTO food) {
        responseDTO respuesta = foodService.updateFood(idFood, food);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
