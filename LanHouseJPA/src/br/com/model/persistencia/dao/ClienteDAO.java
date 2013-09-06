

package br.com.model.persistencia.dao;

import br.com.model.negocio.Cliente;
import br.com.model.negocio.Cliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruno_figueiredo
 */
public interface ClienteDAO extends DAO<Cliente, Integer>{
      
    List<Cliente> getByNome (String nome);
    Cliente getClienteByNome(String nome);
     List<Cliente> getClientesByNome(String nome);
    Cliente getClienteByNomeCpfRgDatanascCidadeEstadoEndereco(String nome, String cpf, String rg, Date datanacs, String cidade, String Estado, String Endereco);
}
