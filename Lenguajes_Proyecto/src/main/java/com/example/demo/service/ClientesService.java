/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.domain.Clientes;
import java.util.List;

public interface ClientesService {
    List<Clientes> getClientes(boolean activos);

    Clientes getClientes(Clientes cliente);

    void save(Clientes cliente);

    void delete(Clientes cliente);

    void deleteById(String clienteId);
}
