
package br.com.modelo.persistencia;

import br.com.modelo.negocio.Modelo;
import java.util.List;

/**
 *
 * @author rosicleia.souza
 */
public interface ModeloDAO {
    
    void inserir(Modelo m);
    void atualizar(Modelo m);
    void excluir (int id);
    List<Modelo> getModelos();
    List<Modelo> getModelosByNome(String nome);
    Modelo getModelosById(int id);
    Modelo getModeloByNome (String nome);
    Modelo getModeloByDescricaoPotencia(String descricao, int potencia);
}
