/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.rest;

import com.pos.entity.Ventas;
import com.pos.repository.VentasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author RICARDO
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="*")
public class VentasRest {
 
    @Autowired
    VentasRepository ventasRepository;
    
    
    
    @GetMapping("/ventas/list")
    public List<Ventas> findAllVentas(){
        return ventasRepository.findAll();
    }
    
    @PostMapping("/ventas/add")
    public Ventas addVentas(@RequestBody Ventas ventas){
        return ventasRepository.save(ventas);
    }
    
    @GetMapping("/ventas/id/{id}")
    public List<Ventas> findVentas_porID(@PathVariable("id") Integer id){
        return ventasRepository.findVentas_porID(id);
    }
    
     @GetMapping("/ventas/nativo/{id}")
    public List<Ventas> findVentas_porIdNativo (@PathVariable("id") Integer id){
        return ventasRepository.findVentas_porIdNativo(id);
    }
    
    
     @GetMapping("/ventas/documento/{doc}")
    public List<Ventas> findVentas_porDocumento(@PathVariable("doc") String doc){
        return ventasRepository.findVentas_porDocumento(doc);
    }
    
    
    
}
