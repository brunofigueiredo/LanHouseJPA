/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.negocio.Atendente;
import br.com.model.persistencia.dao.AtendenteDAO;
import br.com.model.presistencia.AtendenteDAOImpl;
import java.util.List;

/**
 *
 * @author bruno_figueiredo
 */
public class AtendenteController {
    
      public boolean salvar(Atendente Atendente) {
        AtendenteDAO dao = new AtendenteDAOImpl();
       return dao.save(Atendente);

    }

    public boolean excluir(int id) {
        AtendenteDAO dao = new AtendenteDAOImpl();
        return dao.remove(Atendente.class, id);

    }
    
    public List<Atendente> listarAtendente() {
        AtendenteDAO dao = new AtendenteDAOImpl();
        return dao.getAll(Atendente.class);
    }
    
    public Atendente listarAtendenteById (int id){
        AtendenteDAO dao = new AtendenteDAOImpl();
        return dao.getById(Atendente.class, id);
    }
    public Atendente listaAtendenteByNome (String nome){
        
        AtendenteDAO dao = new AtendenteDAOImpl();
       return dao.getAtendenteByNome(nome);
        
    }
    public Atendente listaAtendenteByNomeCpfRg (String nome, String cpf, String rg){
         AtendenteDAO dao = new AtendenteDAOImpl();
        return dao.getAtendenteByNomeCpfRg(nome, cpf, rg);
    }
    
    
    
   
     }

    
