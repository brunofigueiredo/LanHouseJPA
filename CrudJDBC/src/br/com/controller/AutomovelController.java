

package br.com.controller;

import br.com.modelo.negocio.Automovel;
import br.com.modelo.persistencia.AutomovelDAO;
import br.com.modelo.persistencia.AutomovelDAOJDBC;
import java.util.List;


/**
 *
 * @author Rosicléia Frasson
 */
public class AutomovelController {
    
    
     public void cadastrar(Automovel automovel) {
        AutomovelDAO dao = new AutomovelDAOJDBC();
        dao.inserir(automovel);

    }

    public void atualizar(Automovel automovel) {
        AutomovelDAO dao = new AutomovelDAOJDBC();
        dao.atualizar(automovel);

    }

    public void excluir(int id) {
        AutomovelDAO dao = new AutomovelDAOJDBC();
        dao.excluir(id);

    }
    
    public List<Automovel> listarAutomovel() {
        AutomovelDAO dao = new AutomovelDAOJDBC();
        return dao.getAutomoveis();
    }
    
    public Automovel listarAutomovelById (int id){
        AutomovelDAO dao = new AutomovelDAOJDBC();
        return dao.getAutomovelById(id);
    }
    
   public List<Automovel> listarAutomovelByAno (String ano){
        AutomovelDAO dao = new AutomovelDAOJDBC();
        return dao.getAutomoveisByAno(ano);
    }
   
   public Automovel listarAutomovelByAnoPreco(int anoFabricacao, int anoModelo, String observacoes){
       AutomovelDAO dao = new AutomovelDAOJDBC();
       return dao.getAutomovelByAnoPreco(anoFabricacao, anoModelo, observacoes);
   }
        
        

}
