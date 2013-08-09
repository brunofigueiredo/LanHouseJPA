package br.com.modelo.persistencia;



import br.com.modelo.negocio.Automovel;
import br.com.modelo.negocio.Marca;
import br.com.modelo.negocio.Modelo;
import br.com.modelo.persistencia.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rosicleia.souza
 */
public class AutomovelDAOJDBC implements AutomovelDAO {

    private final String INSERT = "INSERT INTO AUTOMOVEL (ANO_FABRICACAO, ANO_MODELO, OBSERVACOES, PRECO, QUILOMETRAGEM, MODELO_ID) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE AUTOMOVEL SET ANO_FABRICACAO = ?, ANO_MODELO = ?, OBSERVACOES = ?, PRECO = ?, QUILOMETRAGEM = ?, MODELO_ID = ? WHERE ID = ?";
    private final String DELETE = "DELETE FROM AUTOMOVEL WHERE ID = ?";
    private final String LIST = "SELECT * FROM AUTOMOVEL, MODELO, MARCA WHERE "
            + "AUTOMOVEL.MODELO_ID = MODELO.ID "
            + "AND MODELO.MARCA = MARCA.ID";
    private final String LISTBYNOME = "SELECT * FROM AUTOMOVEL, MODELO, MARCA WHERE "
            + "NOME LIKE ? AND "
            + "AUTOMOVEL.MODELO_ID = MODELO.ID "
            + "AND MODELO.MARCA = MARCA.ID";
    private final String LISTBYID = "SELECT * FROM AUTOMOVEL, MODELO, MARCA WHERE"
            + " ID = ? AND "
            + "AUTOMOVEL.MODELO_ID = MODELO.ID "
            + "AND MODELO.MARCA = MARCA.ID";

    public void inserir(Automovel m) {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setInt(1, m.getAnoFabricacao());
            pstm.setInt(2,m.getAnomodelo());
            pstm.setString(3, m.getObservacoes());
            pstm.setDouble(4, m.getPreco());
            pstm.setInt(5, m.getQuilometragem());
            pstm.setInt(6, m.getModelo().getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Automovel cadastrada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar um automovel: "
                    + e.getMessage());
        }
    }

    public void atualizar(Automovel m) {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setInt(1, m.getAnoFabricacao());
            pstm.setInt(2,m.getAnomodelo());
            pstm.setString(3, m.getObservacoes());
            pstm.setDouble(4, m.getPreco());
            pstm.setInt(5, m.getQuilometragem());
            pstm.setInt(6, m.getModelo().getId());
            pstm.setInt(7, m.getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Automovel atualizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar um automovel: "
                    + e.getMessage());
        }
    }

    public void excluir(int id) {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Automovel excluído com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir um automovel: "
                    + e.getMessage());
        }
    }

    public List<Automovel> getAutomovels() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Automovel a = new Automovel();
                Modelo mo = new Modelo(); 
                Marca ma = new Marca();
                
                a.setId(rs.getInt("automovel.id"));
                a.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                a.setAnomodelo(rs.getInt("ano_modelo"));
                a.setObservacoes(rs.getString("observacoes"));
                a.setPreco(rs.getFloat("preco"));
                a.setQuilometragem(rs.getInt("quilometragem"));
                
                mo.setId(rs.getInt("modelo.id"));
                mo.setDescricao(rs.getString("modelo.descricao"));
                mo.setPotencia(rs.getInt("modelo.potencia"));
                
                
                ma.setId(rs.getInt("marca.id"));
                ma.setNome(rs.getString("marca.nome"));
                
                mo.setMarca(ma);
                a.setModelo(mo);
            
                automoveis.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as automoveis: "
                    + e.getMessage());
        }
        return automoveis;
    }

    public List<Automovel> getAutomovelsByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            pstm.setString(1, '%' + nome + '%');
            rs = pstm.executeQuery();

            while (rs.next()) {
               Automovel a = new Automovel();
                Modelo mo = new Modelo(); 
                Marca ma = new Marca();
                
                a.setId(rs.getInt("automovel.id"));
                a.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                a.setAnomodelo(rs.getInt("ano_modelo"));
                a.setObservacoes(rs.getString("observacoes"));
                a.setPreco(rs.getFloat("preco"));
                a.setQuilometragem(rs.getInt("quilometragem"));
                
                mo.setId(rs.getInt("modelo.id"));
                mo.setDescricao(rs.getString("modelo.descricao"));
                mo.setPotencia(rs.getInt("modelo.potencia"));
                
                
                ma.setId(rs.getInt("marca.id"));
                ma.setNome(rs.getString("marca.nome"));
                
                mo.setMarca(ma);
                a.setModelo(mo);
                automoveis.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as automoveis: "
                    + e.getMessage());
        }
        return automoveis;
    }

    public Automovel getAutomovelsById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Automovel automovel = new Automovel();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Automovel a = new Automovel();
                Modelo mo = new Modelo(); 
                Marca ma = new Marca();
                
                a.setId(rs.getInt("automovel.id"));
                a.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                a.setAnomodelo(rs.getInt("ano_modelo"));
                a.setObservacoes(rs.getString("observacoes"));
                a.setPreco(rs.getFloat("preco"));
                a.setQuilometragem(rs.getInt("quilometragem"));
                
                mo.setId(rs.getInt("modelo.id"));
                mo.setDescricao(rs.getString("modelo.descricao"));
                mo.setPotencia(rs.getInt("modelo.potencia"));
                
                
                ma.setId(rs.getInt("marca.id"));
                ma.setNome(rs.getString("marca.nome"));
                
                mo.setMarca(ma);
                a.setModelo(mo);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as automoveis: "
                    + e.getMessage());
        }
        return automovel;
    }

    
    public Automovel getAutomovelByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Automovel automovel = new Automovel();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();

            while (rs.next()) {

               Automovel a = new Automovel();
                Modelo mo = new Modelo(); 
                Marca ma = new Marca();
                
                a.setId(rs.getInt("automovel.id"));
                a.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                a.setAnomodelo(rs.getInt("ano_modelo"));
                a.setObservacoes(rs.getString("observacoes"));
                a.setPreco(rs.getFloat("preco"));
                a.setQuilometragem(rs.getInt("quilometragem"));
                
                mo.setId(rs.getInt("modelo.id"));
                mo.setDescricao(rs.getString("modelo.descricao"));
                mo.setPotencia(rs.getInt("modelo.potencia"));
                
                
                ma.setId(rs.getInt("marca.id"));
                ma.setNome(rs.getString("marca.nome"));
                
                mo.setMarca(ma);
                a.setModelo(mo);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as automoveis: "
                    + e.getMessage());
        }
        return automovel;
    }
}
