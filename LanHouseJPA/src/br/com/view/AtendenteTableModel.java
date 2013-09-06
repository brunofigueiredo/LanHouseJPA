/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.model.negocio.Atendente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;


    
/**
 *
 * @author bruno_figueiredo
 */
public class AtendenteTableModel extends AbstractTableModel{
    
    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_RG = 2;
    private static final int COL_CPF = 3;
    
    private List<Atendente> linhas;
    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"id", "nome", "rg", "cpf"};

    
     //Cria uma ModeloTableModel sem nenhuma linha
    public AtendenteTableModel() {
        linhas = new ArrayList<Atendente>();
    }

    //Cria uma ModeloTableModel contendo a lista recebida por parâmetro.
    public AtendenteTableModel(List<Atendente> atendentes) {
        this.linhas = new ArrayList<Atendente>(atendentes);
    }
    
    @Override
    public int getRowCount() {
        
        return linhas.size();
    }

    /*
     * Retorna a quantidade de colunas
     * 2 colunas: uma para id e a outra para nome.
     */
        


    @Override
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
        Atendente a = linhas.get(row);

        //verifica qual valor deve ser retornado
        if (column == COL_ID) {
            return a.getId();
         } else if (column == COL_NOME) {
            return a.getNome();
        } else if (column == COL_RG){
            return a.getRg();
        } else if (column == COL_CPF){
            return a.getCpf();
        }
        return "";
   
    }
    
   
    public void setValueAt(Object aValue, int row, int column) {
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 2 campos ao invés de um só. 
        
        Atendente u = linhas.get(row);
        if (column == COL_ID) {
            u.setId((Integer) aValue);
        } else if (column == COL_NOME) {
            u.setNome(aValue.toString());
        } else if (column == COL_RG) {
            u.setRg(aValue.toString());
        } else if (column == COL_CPF) {
            u.setCpf(aValue.toString());
        }
    }
         // Retorna a marca referente a linha especificada
    public Atendente getAtendente(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

// Adiciona a marca especificada ao automovel
    public void addAtendente(Atendente marca) {
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

    public void updateAtendente(int indiceLinha, Atendente marca) {
        linhas.set(indiceLinha, marca);
        // Notifica a mudança.
        fireTableRowsUpdated(indiceLinha, indiceLinha);
        ordenarPorAnoFabricacao();
    }

    //Remove o sócio da linha especificada.
    public void removeAtendente(int indiceLinha) {
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
        Collections.sort(linhas, new Comparator<Atendente>() {

            public int compare(Atendente o1, Atendente o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
                
            
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
}

     
    

    

    

       


