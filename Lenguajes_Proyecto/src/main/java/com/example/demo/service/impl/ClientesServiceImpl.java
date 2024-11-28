/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service.impl;

import com.example.demo.dao.ClientesDao;
import com.example.demo.domain.Clientes;
import com.example.demo.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesDao clientesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Clientes> getClientes(boolean activos) {
        return clientesDao.findAll(); 
    }

    @Override
    @Transactional(readOnly = true)
    public Clientes getClientes(Clientes cliente) {
        return clientesDao.findById(cliente.getClienteId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Clientes cliente) {
        clientesDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Clientes cliente) {
        clientesDao.delete(cliente);
    }

    @Override
    @Transactional
    public void deleteById(String clienteId) {
        clientesDao.deleteById(clienteId);
    }
}
