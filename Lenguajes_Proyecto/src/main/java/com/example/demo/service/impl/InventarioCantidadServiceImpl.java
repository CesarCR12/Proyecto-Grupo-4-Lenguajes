/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.InventarioCantidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Service
public class InventarioCantidadServiceImpl implements InventarioCantidadService {

    @Autowired
    private DataSource dataSource; 

    @Override
    public Integer obtenerCantidadPorNombre(String nombre) {
        Integer cantidad = null;
        try (Connection connection = dataSource.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{? = call FIDE_INVENTARIO_TB_CANTIDAD_POR_NOMBRE_FN(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER); 
            callableStatement.setString(2, nombre); 
            callableStatement.execute();
            cantidad = callableStatement.getInt(1); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cantidad;
    }
}
