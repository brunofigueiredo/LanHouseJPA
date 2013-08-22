
package br.com.modelo.negocio;

/**
 *
 * @author rosicleia.souza
 */
public class Automovel {
    
    private int id;
    private int anoFabricacao;
    private int anoModelo;
    private String observacoes;
    private double preco;
    private int quilometragem;
    private Modelo modelo;

    public Automovel() {
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the anoFabricacao
     */
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    /**
     * @param anoFabricacao the anoFabricacao to set
     */
    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    /**
     * @return the anomodelo
     */
    public int getAnoModelo() {
        return anoModelo;
    }

    /**
     * @param anomodelo the anomodelo to set
     */
    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the quilometragem
     */
    public int getQuilometragem() {
        return quilometragem;
    }

    /**
     * @param quilometragem the quilometragem to set
     */
    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
     
    public int compareTo(Automovel o) {
        if (this.anoFabricacao < o.getAnoFabricacao()) {
            return -1;
        }
        if (this.anoFabricacao > o.getAnoFabricacao()) {
            return 1;
        }
        return 0;
    }
}
