package com.wellyntonmartins.wellyntonservices.repositories;

import com.wellyntonmartins.wellyntonservices.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// Aqui, o parametro "Order", do extends, diz que e da entidade "Order" no package entities, assim o JPA disponibiliza
// metodos proprios para criar, buscar, atualizar, deletar dados na entidade enviada no parametro, caso
// ela exista em entities e seja definida como uma entidade pro JPA
public interface OrderRepository extends JpaRepository<Order, Long> {

}
