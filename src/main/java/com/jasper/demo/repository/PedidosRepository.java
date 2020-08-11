package com.jasper.demo.repository;

import com.jasper.demo.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {


    //Collection<Pedidos> findByRamdon(String id);

}
