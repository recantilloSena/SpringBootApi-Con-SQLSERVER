/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.repository;

import com.pos.entity.Ventas;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author RICARDO
 */
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
    
    @Query("SELECT v FROM Ventas v WHERE v.idVentas = :idVentas")
    List<Ventas> findVentas_porID(@Param("idVentas") Integer idVentas);
    
    @Query(value = "SELECT * FROM Ventas v WHERE v.id_ventas = :idVentas",nativeQuery = true)
    List<Ventas> findVentas_porIdNativo(@Param("idVentas") Integer idVentas);
    
    @Query("SELECT v FROM Ventas v WHERE v.fkCliente.documento = :documento")
    List<Ventas> findVentas_porDocumento(@Param("documento") String documento);
    
    
}
