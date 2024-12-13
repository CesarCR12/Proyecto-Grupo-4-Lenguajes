/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.service.PalletProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

@Service
public class PalletProveedorServiceImpl implements PalletProveedorService {

    @Autowired
    private DataSource dataSource; 

    @Override
    public String obtenerProveedorPorPallet(String idPallet) {
        String resultado = "Error al obtener el proveedor";
        try (Connection connection = dataSource.getConnection()) { 
            CallableStatement callableStatement = connection.prepareCall("{? = call FIDE_PALLETS_TB_OBTENER_PROVEEDOR_FN(?)}");
            callableStatement.registerOutParameter(1, Types.VARCHAR); 
            callableStatement.setString(2, idPallet); 
            callableStatement.execute();
            resultado = callableStatement.getString(1); 
        } catch (Exception e) {
            resultado = "Error: " + e.getMessage();
        }
        return resultado;
    }
}
