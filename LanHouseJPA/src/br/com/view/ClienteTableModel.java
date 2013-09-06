package br.com.view;


import br.com.model.negocio.Atendente;
import br.com.model.negocio.Cliente;
import br.com.model.negocio.Cliente;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author bruno_figueiredo
 */
public class ClienteTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_RG = 2;
     private static final int COL_CPF = 3;
    private static final int COL_DATANASC = 4;
    private static final int COL_CIDADE = 5;
    private static final int COL_ESTADO = 6;
    private static final int COL_ENDERECO = 7;
    private static final int COL_ATENDENTE = 8;
    
    private List<Cliente> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"id", "nome", "rg","cpf", "datanasc","cidade","estado", "endereco", "atendente"};

    //Cria uma ModeloTableModel sem nenhuma linha
    public ClienteTableModel() {
        linhas = new ArrayList<Cliente>();
    }

    //Cria uma ModeloTableModel contendo a lista recebida por parâmetro.
    public ClienteTableModel(List<Cliente> clientes) {
        this.linhas = new ArrayList<Cliente>(clientes);
    }

    public int getRowCount() {
        return linhas.size();
    }

    /*
     * Retorna a quantidade de colunas
     * 2 colunas: uma para id e a outra para nome.
     */
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public Class getColumnClass(int columnIndex) {
        //Qual a classe das nossas colunas? A coluna 1 é inteira, as outras string.  
        if (columnIndex == COL_ID) {
            return Integer.class;
        }else if (columnIndex == COL_NOME ){
            return String.class;
        }else if (columnIndex == COL_RG){
            return String.class;
        }else if (columnIndex == COL_CPF){
            return String.class;
        }else if (columnIndex == COL_DATANASC){
            return Date.class;
         }else if (columnIndex == COL_ENDERECO){
            return String.class;
         
        }else if (columnIndex == COL_CIDADE){
               return String.class;
        }else if (columnIndex == COL_ESTADO){
            return String.class;
        }else if (columnIndex == COL_ATENDENTE){
            return Cliente.class;
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Retorna o valor da coluna e o valor da linha
    public Object getValueAt(int row, int column) {
        //pega a marca da linha
        Cliente m = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_NOME) {
            return m.getNome();
        } else if (column == COL_RG){
            return m.getRg();
        } else if (column == COL_CPF){
            return m.getCpf();
            
        } else if (column == COL_DATANASC){
            return m.getDatanasc();
        } else if (column == COL_ENDERECO){
            return m.getEndereco();
            
        } else if (column == COL_CIDADE){
            return m.getCidade();
            
            
          } else if (column == COL_ESTADO){
            return m.getEstado();
         
         } else if (column == COL_ATENDENTE){
            return m.getAtendente();
            
        
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Cliente u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_NOME) {
            u.setNome(aValue.toString());
        } else if (column == COL_RG) {
            u.setRg(aValue.toString());
        
         } else if (column == COL_CPF) {
            u.setCpf (aValue.toString());
         
          } else if (column == COL_DATANASC) {
            u.setDatanasc((Date) aValue);
          
          } else if (column == COL_ENDERECO) {
            u.setEndereco(aValue.toString());
          
            } else if (column == COL_CIDADE) {
            u.setCidade(aValue.toString());
            
         
            } else if (column == COL_ESTADO) {
            u.setEstado(aValue.toString());
            
             } else if (column == COL_ATENDENTE) {
            u.setAtendente((Atendente) aValue);
        }
    }

    // Retorna a marca referente a linha especificada
    public Cliente getCliente(int indiceLinha) {
        return linhas.get(indiceLinha);
    }


// Adiciona a marca especificada ao modelo
    public void addCliente(Cliente cliente) {
        // Adiciona o registro.
        linhas.add(cliente);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        ordenarPorDescricao();

    }
    
        public void updateCliente(int indiceLinha, Cliente cliente) {
            linhas.set(indiceLinha, cliente);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
        ordenarPorDescricao();
    }
    
    //Remove o sócio da linha especificada.
    public void removeCliente(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        ordenarPorDescricao();
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }
    
    public void ordenarPorDescricao() {
        //ordena pelo nome
        Collections.sort(linhas, new Comparator<Cliente>() {

            public int compare(Cliente o1, Cliente o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
}
