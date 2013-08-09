package br.com.modelo.controller;

import br.com.modelo.negocio.Automovel;
import br.com.modelo.persistencia.AutomovelDAO;
import br.com.modelo.persistencia.AutomovelDAOJDBC;
import java.util.List;

/**
 *
 * @author rosicleia.souza
 */
public class AutomovelController {

    public void inserir(Automovel m) {
        AutomovelDAO md = new AutomovelDAOJDBC();
        md.inserir(m);
    }

    public void atualizar(Automovel m) {
        AutomovelDAO md = new AutomovelDAOJDBC();
        md.atualizar(m);
    }

    public void excluir(int id) {
        AutomovelDAO md = new AutomovelDAOJDBC();
        md.excluir(id);
    }

    public List<Automovel> getAutomovel() {
        AutomovelDAO md = new AutomovelDAOJDBC();
        return md.getAutomovels();
    }

    public List<Automovel> getAutomovelByNome(String nome) {
        AutomovelDAO md = new AutomovelDAOJDBC();
        return md.getAutomovelsByNome(nome);
    }

    public Automovel getAutomovelById(int id) {
        AutomovelDAO md = new AutomovelDAOJDBC();
        return md.getAutomovelsById(id);
    }

    public Automovel getMarcByNome(String nome) {
        AutomovelDAO md = new AutomovelDAOJDBC();
        return md.getAutomovelByNome(nome);
    }
}
