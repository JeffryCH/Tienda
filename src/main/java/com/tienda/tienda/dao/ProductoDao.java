/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Laboratorios
 */
public interface ProductoDao extends JpaRepository <Producto, Long>{
    
    //Esta consulta ampliada utiliza metodo jQuery
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    //Esta consulta utiliza lenguaje
    @Query(value = "SELECT p FROM Producto p where p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto> meotodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Esta consulta utiliza lenguaje SQL nativo
    @Query(nativeQuery = true, value = "SELECT p FROM Producto p where p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto> meotodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
}
