package br.com.view;

import br.com.modelo.negocio.Automovel;
import br.com.modelo.negocio.Modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Rosicléia Frasson
 */
public class AutomovelTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_ANOFABRICACAO = 1;
    private static final int COL_ANOMODELO = 2;
    private static final int COL_PRECO = 3;
    private static final int COL_MODELO = 4;
    private List<Automovel> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"Código", "Ano Fabricação", "Ano Modelo", "Preço", "Modelo"};

    //Cria uma AutomovelTableModel sem nenhuma linha
    public AutomovelTableModel() {
        linhas = new ArrayList<Automovel>();
    }

    //Cria uma AutomovelTableModel contendo a lista recebida por parâmetro.
    public AutomovelTableModel(List<Automovel> automovels) {
        this.linhas = new ArrayList<Automovel>(automovels);
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
        } else if (columnIndex == COL_ANOFABRICACAO) {
            return Integer.class;
        } else if (columnIndex == COL_ANOMODELO) {
            return Integer.class;
        } else if (columnIndex == COL_PRECO) {
            return Double.class;
        } else if (columnIndex == COL_MODELO) {
            return Modelo.class;
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
        Automovel m = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return m.getId();
        } else if (column == COL_ANOFABRICACAO) {
            return m.getAnoFabricacao();
        } else if (column == COL_ANOMODELO) {
            return m.getAnoModelo();
        } else if (column == COL_PRECO) {
            return m.getPreco();
        } else if (column == COL_MODELO) {
            return m.getModelo();
        }
        return "";
    }

    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só.  
        Automovel u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_ANOFABRICACAO) {
            u.setAnoFabricacao((Integer) aValue);
        } else if (column == COL_ANOMODELO) {
            u.setAnoModelo((Integer) aValue);
        } else if (column == COL_PRECO) {
            u.setPreco((Float) aValue);
        } else if (column == COL_MODELO) {
            u.setModelo((Modelo) aValue);
        }
    }

    // Retorna a marca referente a linha especificada
    public Automovel getAutomovel(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

// Adiciona a marca especificada ao automovel
    public void addAutomovel(Automovel marca) {
        // Adiciona o registro.
        linhas.add(marca);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;


        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        ordenarPorAnoFabricacao();

    }

    public void updateAutomovel(int indiceLinha, Automovel marca) {
        linhas.set(indiceLinha, marca);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
        ordenarPorAnoFabricacao();
    }

    //Remove o sócio da linha especificada.
    public void removeAutomovel(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
        ordenarPorAnoFabricacao();
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }

    public void ordenarPorAnoFabricacao() {
        //ordena pelo nome
        Collections.sort(linhas, new Comparator<Automovel>() {
            public int compare(Automovel o1, Automovel o2) {
                return o1.compareTo(o2);
                
                
            }
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
}
