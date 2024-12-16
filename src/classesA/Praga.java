package classesA;

public abstract class Praga {
    protected String nome;

    public Praga(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void atacarPlanta(Planta planta);

    public String toString(){
        return "nome "+nome;
    }
}
