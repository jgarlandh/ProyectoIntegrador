package com.generation.simplisoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.simplisoft.model.Order;
import com.generation.simplisoft.service.OrderService;

//se debe especificar que es una clase de tipo controlador
/*
Es una anotación utilizada para marcar una clase que se encargará 
de manejar solicitudes HTTP y enviar respuestas en forma de objetos
Java serializados en formato JSON o XML.

*/
@Controller
// se debe especificar el origen de las peticiones, en este caso pueden
// venir de cualquier lado!
@CrossOrigin("*")
/*
 * Un controlador de REST, marcado con la anotación @RestController,
 * funciona como una combinación de las anotaciones @Controller y
 * 
 * @ResponseBody
 */
@RestController

public class OrderController {
    
    public OrderService orderService;
    
    /*
    * Se inicia el Constructor
    * La anotación @Autowired se puede usar en el constructor
    * para inyectar la instancia de
    * OrderService en la variable de instancia orderService.
    * 
    * Esto se hace mediante la funcionalidad de la inyección de
    * dependencias de Spring Framework.
    */
    
    public OrderController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }
    /* --------------------------------- */
    /* Métodos POST / GET / DELETE / PUT */
    /* --------------------------------- */

    // POST: Para ingresar datos a la BD
    @PostMapping("/order/save")
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    // PUT: Para editar datos en la BD
    @PutMapping("/order/Update")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    // DELETE: Eliminar/Borrar datos de BD
    @DeleteMapping("/order/Delete/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }

    // GET: Para obtener datos de la BD
    @GetMapping("/order/FindAll")
    public List<Order> getOrder() {
        return orderService.findAll();
    }
}