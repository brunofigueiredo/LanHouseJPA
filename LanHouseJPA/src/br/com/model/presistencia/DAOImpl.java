/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.presistencia;

import br.com.model.persistencia.dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno_figueiredo
 */
public class DAOImpl <T, I extends Serializable> implements DAO<T, I>  {
      private ConnectionFactory conexao;
      
      
      public boolean save(T entity) {
        T saved = null;
        try {
            getEntityManager().getTransaction().begin();
            saved = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive() == false) {
                getEntityManager().getTransaction().begin();
            }
            getEntityManager().getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao salvar na base de dados");
        }
        return false;

    }
      
       public boolean remove(Class<T> classe, I pk) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().getReference(classe, pk));
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (getEntityManager().getTransaction().isActive() == false) {
                getEntityManager().getTransaction().begin();
            }
            getEntityManager().getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao excluir da base de dados.");
        }
        return false;
    }

    public T getById(Class<T> classe, I pk) {
        try {
            return getEntityManager().find(classe, pk);

        } catch (NoResultException e) {
            return null;
        }
    }

    public List<T> getAll(Class<T> classe) {

        return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
    }

    public EntityManager getEntityManager() {
        if (conexao == null) {
            conexao = new ConnectionFactory();
        }
        return conexao.getEntityManager();
    }
}


