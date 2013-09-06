/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.negocio.Cliente;
import br.com.model.persistencia.dao.ClienteDAO;

import br.com.model.presistencia.ClienteDAOImpl;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruno_figueiredo
 */
public class ClienteController {
    
      public boolean salvar(Cliente Cliente) {
        ClienteDAO dao = new ClienteDAOImpl();
       return dao.save(Cliente);

    }

    public boolean excluir(int id) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.remove(Cliente.class, id);

    }
    
    public List<Cliente> listarCliente() {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.getAll(Cliente.class);
    }
    public List<Cliente> listaCliente(String nome) {
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.getClientesByNome(nome);
    }
    
    public Cliente listarClienteById (int id){
        ClienteDAO dao = new ClienteDAOImpl();
        return dao.getById(Cliente.class, id);
    }
    public Cliente listaClienteByNome (String nome){
        
        ClienteDAO dao = new ClienteDAOImpl();
       return dao.getClienteByNome(nome);
        
    }
    public Cliente listaClienteByNomeCpfRgDatanascCidadeEstadoEndereco (String nome, String cpf, String rg, Date datanacs, String cidade, String estado, String endereco){
         ClienteDAO dao = new ClienteDAOImpl();
        return dao.getClienteByNomeCpfRgDatanascCidadeEstadoEndereco(nome, cpf, rg,datanacs, cidade, estado, endereco);
    }
    
    
    
   
     }

    
