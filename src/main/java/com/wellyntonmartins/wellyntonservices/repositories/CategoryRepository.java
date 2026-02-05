package com.wellyntonmartins.wellyntonservices.repositories;

import com.wellyntonmartins.wellyntonservices.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Aqui, o parametro "User", do extends, diz que e da entidade "User" no package entities, assim o JPA disponibiliza
// metodos proprios para criar, buscar, atualizar, deletar dados na entidade enviada no parametro, caso
// ela exista em entities e seja definida como uma entidade pro JPA
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
