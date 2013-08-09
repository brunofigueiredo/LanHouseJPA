package br.com.modelo.controller;

import br.com.modelo.negocio.Modelo;
import br.com.modelo.persistencia.ModeloDAO;
import br.com.modelo.persistencia.ModeloDAOJDBC;
import java.util.List;

/**
 *
 * @author rosicleia.souza
 */
public class ModeloController {

    public void inserir(Modelo m) {
        ModeloDAO md = new ModeloDAOJDBC();
        md.inserir(m);
    }

    public void atualizar(Modelo m) {
        ModeloDAO md = new ModeloDAOJDBC();
        md.atualizar(m);
    }

    public void excluir(int id) {
        ModeloDAO md = new ModeloDAOJDBC();
        md.excluir(id);
    }

    public List<Modelo> getModelo() {
        ModeloDAO md = new ModeloDAOJDBC();
        return md.getModelos();
    }

    public List<Modelo> getModeloByNome(String nome) {
        ModeloDAO md = new ModeloDAOJDBC();
        return md.getModelosByNome(nome);
    }

    public Modelo getModeloById(int id) {
        ModeloDAO md = new ModeloDAOJDBC();
        return md.getModelosById(id);
    }

    public Modelo getMarcByNome(String nome) {
        ModeloDAO md = new ModeloDAOJDBC();
        return md.getModeloByNome(nome);
    }
}
