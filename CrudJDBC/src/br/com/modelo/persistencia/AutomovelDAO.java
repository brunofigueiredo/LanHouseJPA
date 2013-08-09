
package br.com.modelo.persistencia;

import br.com.modelo.negocio.Automovel;
import java.util.List;

/**
 *
 * @author rosicleia.souza
 */
public interface AutomovelDAO {
    
    void inserir(Automovel a);
    void atualizar(Automovel a);
    void excluir (int id);
    List<Automovel> getAutomovels();
    List<Automovel> getAutomovelsByNome(String nome);
    Automovel getAutomovelsById(int id);
    Automovel getAutomovelByNome (String nome);
    
}
