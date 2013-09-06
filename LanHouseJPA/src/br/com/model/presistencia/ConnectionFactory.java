/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model.presistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno_figueiredo
 */
public class ConnectionFactory {
     
    private static final String UNIT_NAME = "LanHouseJPAPU";
    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public EntityManager getEntityManager() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(UNIT_NAME);
        }

        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
}

}