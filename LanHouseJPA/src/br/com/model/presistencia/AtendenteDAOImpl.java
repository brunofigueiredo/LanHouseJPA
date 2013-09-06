package br.com.model.presistencia;

import br.com.model.negocio.Atendente;
import br.com.model.persistencia.dao.AtendenteDAO;
import br.com.model.negocio.Atendente;
import br.com.model.persistencia.dao.AtendenteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author bruno_figueiredo
 */
public class AtendenteDAOImpl extends DAOImpl<Atendente, Integer> implements AtendenteDAO {
    public List<Atendente> getByNome(String nome) {
        return getEntityManager().createQuery("select a from Atendente a where a.nome like"
                + " '%" + nome + "%'").getResultList();
    }

    @Override
    public Atendente getAtendenteByNome(String nome) {
        Query q = getEntityManager().createQuery("select a from Atendente a where a.nome"
                + " like '" + nome + "'", Atendente.class);
        List<Atendente> atendentes = q.getResultList();
        Atendente ma = new Atendente();
        for (Atendente m : atendentes) {
            ma = m;
        }
        return ma;
    }

    public Atendente getAtendenteByNomeCpfRg(String nome, String cpf, String rg) {
        Query q = getEntityManager().createQuery("select a from Atendente a where a.nome "
                + " like '%" + nome + "%' and a.cpf like '%" + cpf +
                "%' and a.rg like '%" + rg + "%'", Atendente.class);
        List<Atendente> atendentes = q.getResultList();
        Atendente ma = new Atendente();
        for (Atendente m : atendentes) {
            ma = m;
        }
        return ma;
    }

    

    
 
   
}
