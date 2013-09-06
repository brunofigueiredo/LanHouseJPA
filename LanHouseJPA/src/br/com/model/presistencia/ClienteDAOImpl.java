package br.com.model.presistencia;

import br.com.model.negocio.Cliente;
import br.com.model.persistencia.dao.ClienteDAO;
import br.com.model.negocio.Cliente;
import br.com.model.persistencia.dao.ClienteDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author bruno_figueiredo
 */
public class ClienteDAOImpl extends DAOImpl<Cliente, Integer> implements ClienteDAO {
    public List<Cliente> getByNome(String nome) {
        return getEntityManager().createQuery("select a from Cliente a where a.nome like"
                + " '%" + nome + "%'").getResultList();
    }

    
    public Cliente getClienteByNome(String nome) {
        Query q = getEntityManager().createQuery("select a from Cliente a where a.nome"
                + " like '" + nome + "'", Cliente.class);
        List<Cliente> clientes = q.getResultList();
        Cliente ma = new Cliente();
        for (Cliente m : clientes) {
            ma = m;
        }
        return ma;
    }

    public Cliente getClienteByNomeCpfRgDatanascCidadeEstadoEndereco (String nome, String cpf, String rg, Date datanacs, String cidade, String Estado, String Endereco) {
        Query q = getEntityManager().createQuery("select a from Cliente a where a.nome "
                + " like '%" + nome + "%' and a.cpf like '%" + cpf +
                "%' and a.rg like '%" + rg + "%'", Cliente.class);
        List<Cliente> clientes = q.getResultList();
        Cliente ma = new Cliente();
        for (Cliente m : clientes) {
            ma = m;
        }
        return ma;
    }

    public List<Cliente> getClientesByNome(String nome) {
        return getEntityManager().createQuery("select a from Cliente a where a.nome like"
                + " '%" + nome + "%'").getResultList();
        
    }

    

    
 
   
}
