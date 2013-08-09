package br.com.modelo.persistencia;

import br.com.modelo.negocio.Modelo;
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
public class ModeloDAOJDBC implements ModeloDAO {

    private final String INSERT = "INSERT INTO MARCA (NOME) VALUES (?)";
    private final String UPDATE = "UPDATE MARCA SET NOME = ? WHERE ID = ?";
    private final String DELETE = "DELETE FROM MARCA WHERE ID = ?";
    private final String LIST = "SELECT * FROM MARCA";
    private final String LISTBYNOME = "SELECT * FROM MARCA WHERE NOME LIKE ?";
    private final String LISTBYID = "SELECT * FROM MARCA WHERE ID = ?";

    public void inserir(Modelo m) {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, m.get);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Modelo cadastrada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar uma modelo: "
                    + e.getMessage());
        }
    }

    
    public void atualizar(Modelo m) {
       Connection conn = null;
        try {
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, m.getNome());
            pstm.setInt(2, m.getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Modelo atualizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar um modelo: "
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
            JOptionPane.showMessageDialog(null, "Modelo excluída com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir uma modelo: "
                    + e.getMessage());
        }
    }

    
    public List<Modelo> getModelos() {
       Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setNome(rs.getString("nome"));
                modelos.add(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as modelos: "
                    + e.getMessage());
        }
        return modelos;
    }

    
    public List<Modelo> getModelosByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            pstm.setString(1, '%' + nome + '%');
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setNome(rs.getString("nome"));
                modelos.add(modelo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as modelos: "
                    + e.getMessage());
        }
        return modelos;
    }

   
    public Modelo getModelosById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Modelo modelo = new Modelo();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                
                modelo.setId(rs.getInt("id"));
                modelo.setNome(rs.getString("nome"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as modelos: "
                    + e.getMessage());
        }
        return modelo;
    }

    @Override
    public Modelo getModeloByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Modelo modelo = new Modelo();
        try {
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                
                modelo.setId(rs.getInt("id"));
                modelo.setNome(rs.getString("nome"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as modelos: "
                    + e.getMessage());
        }
        return modelo;
    }
}
