

package br.com.model.persistencia.dao;

import br.com.model.negocio.Atendente;
import br.com.model.negocio.Atendente;
import java.util.List;

/**
 *
 * @author bruno_figueiredo
 */
public interface AtendenteDAO extends DAO<Atendente, Integer>{
      
    List<Atendente> getByNome (String nome);
    Atendente getAtendenteByNome(String nome);
    Atendente getAtendenteByNomeCpfRg(String nome, String cpf, String rg);
}
