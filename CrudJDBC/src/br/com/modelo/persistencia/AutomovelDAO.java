
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
    List<Automovel> getAutomoveis();
    List<Automovel> getAutomoveisByAno(String nome);
    Automovel getAutomovelById(int id);
    Automovel getAutomovelByAno (String nome);
    Automovel getAutomovelByAnoPreco (int anoFabricacao, int anoModelo, String observacoes);
    
}
