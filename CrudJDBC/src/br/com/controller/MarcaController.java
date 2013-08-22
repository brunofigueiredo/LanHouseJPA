

package br.com.controller;

import br.com.modelo.negocio.Marca;
import br.com.modelo.persistencia.MarcaDAO;
import br.com.modelo.persistencia.MarcaDAOJDBC;
import java.util.List;


/**
 *
 * @author Rosicléia Frasson
 */
public class MarcaController {
    
    
     public void cadastrar(Marca marca) {
        MarcaDAO dao = new MarcaDAOJDBC();
        dao.inserir(marca);

    }

    public void atualizar(Marca marca) {
        MarcaDAO dao = new MarcaDAOJDBC();
        dao.atualizar(marca);

    }

    public void excluir(int id) {
        MarcaDAO dao = new MarcaDAOJDBC();
        dao.excluir(id);

    }
    
    public List<Marca> listarMarca() {
        MarcaDAO dao = new MarcaDAOJDBC();
        return dao.getMarcas();
    }
    
    public Marca listarMarcaById (int id){
        MarcaDAO dao = new MarcaDAOJDBC();
        return dao.getMarcasById(id);
    }
    
   public List<Marca> listarMarcasByNome (String nome){
        MarcaDAO dao = new MarcaDAOJDBC();
        return dao.getMarcasByNome(nome);
    }
     
   public Marca listarMarcaByNome (String nome){
       MarcaDAO dao = new MarcaDAOJDBC();
       return dao.getMarcaByNome(nome);
   }
        

}
