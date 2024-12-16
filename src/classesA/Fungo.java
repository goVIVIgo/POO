package classesA;

import exceções.NaoComestivelException;

public abstract class Fungo {

    protected String nome;
    protected boolean umido;

    public Fungo(String nome, boolean umido) {
        this.nome = nome;
        this.umido = umido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setUmido(boolean umido) {
        this.umido = umido;
    }
    public boolean isUmido() {
        return umido;
    }

    public abstract boolean comestivel() throws NaoComestivelException;

    public String toString() {
        return "fungo " + nome + " umido " + umido;
    }
}