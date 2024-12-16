package classesA;

import exceções.PlantaNaoExisteException;

public abstract class Planta {

    protected String nome;
    protected boolean machucada;


    public Planta(String nome, boolean machucada) {
        this.nome = nome;
        this.machucada = machucada;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMachucada() {
        return machucada;
    }
    public void setMachucada(boolean machucada) {
        this.machucada = machucada;
    }

    public abstract void cuidar() throws PlantaNaoExisteException;
    public abstract void colher(int frutos);

    public String toString() {
        return "nome " + nome + " machucada " + machucada;
    }



}
