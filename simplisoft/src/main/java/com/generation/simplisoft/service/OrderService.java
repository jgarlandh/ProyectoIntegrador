package com.generation.simplisoft.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.simplisoft.model.Order;
import com.generation.simplisoft.repository.OrderRepository;

@Service
@Transactional

public class OrderService {

     /* 
        Necesitamos conectar esta clase con la clase repositorio
        (Lo hacemos declarando una variable de tipo OrderRepository)
        
        Asi ésta clase podrá utilizar 
        los métodos CRUD definidos en la interfaz OrderRepository 
        para interactuar con la base.
    */   

    private OrderRepository orderRepository;

    /* Se crea el constructor de esta clase, que tiene como parámetro
     * un objeto de tipo OrderRepository.
     * 
     * Esto quiere decir que la instancia OrderService que se crea
     * tendrá acceso a un objeto de OrderRepository y así poder 
     * interactuar con la base de datos
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /* --------------------------------- */
    /* Inicio de los métodos de la clase */
    /* --------------------------------- */

    // Método SAVE: se hereda de la interfaz JpaRepository
    /*  Este método permite a la esta clase guardar un nuevo objeto order
        en la BD usando el objeto OrderRepository que se 
        inyecto en la clase.    
    */ 

    public void saveOrder(Order order){
        this.orderRepository.save(order);
    }

    // Método ACTUALIZAR/EDITAR/UPDATE
    public void updateOrder(Order order){
        this.orderRepository.save(order);
    }

    // Método para BORRAR/DELETE
    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }

    //Método para BUSCAR/ENCONTRAR a TODOS
    public List<Order> findAll(){
        return orderRepository.findAll();
    }


}