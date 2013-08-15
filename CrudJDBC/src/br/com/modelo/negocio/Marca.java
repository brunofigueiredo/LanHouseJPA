
package br.com.modelo.negocio;

/**
 *
 * @author rosicleia.souza
 */
public class Marca {
    
    private int id;
    private String nome;

    public Marca() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        return this.nome;
    }
    
    
    
}
