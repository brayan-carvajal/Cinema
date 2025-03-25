package com.sena.crud_basic.controller;

import com.sena.crud_basic.dto.customerDTO;
import com.sena.crud_basic.dto.responseDTO;
import com.sena.crud_basic.service.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class customerController {

    /*
     * POST
     * GET
     * PUT
     * DELETE
     */

    @Autowired
    private customerService customerService;

    // POST
    @PostMapping("/post")
    public ResponseEntity<Object> registerCustomer(@RequestBody customerDTO customer) {
        responseDTO respuesta = customerService.save(customer);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    // GET
    @GetMapping("/get")
    public ResponseEntity<Object> getAllCustomer() {
        var listaCustomer = customerService.findAll();
        return new ResponseEntity<>(listaCustomer, HttpStatus.OK);
    }

    // GET:id
    @GetMapping("/{idCustomer}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable int idCustomer) {
        var customer = customerService.findById(idCustomer);
        if (!customer.isPresent())
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // GET: Filtro por nombre
    @GetMapping("/filter/name/{filter}")
    public ResponseEntity<Object> getForName(@PathVariable String filter) {
        var customerList = customerService.getForName(filter);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    // GET: Filtro por email
    @GetMapping("/filter/email/{filter}")
    public ResponseEntity<Object> getForEmail(@PathVariable String filter) {
        var customerList = customerService.getForEmail(filter);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int idCustomer) {
        var message = customerService.deleteCustomer(idCustomer);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // PUT
    @PutMapping("/{idCustomer}")
    public ResponseEntity<Object> updateCustomer(@PathVariable int idCustomer, @RequestBody customerDTO customer) {
        responseDTO respuesta = customerService.updateCustomer(idCustomer, customer);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
