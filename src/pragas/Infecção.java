package pragas;

import classesA.Planta;
import classesA.Praga;

public class Infecção extends Praga {
    public Infecção(String nome) {
        super(nome);
    }

    @Override
    public void atacarPlanta(Planta planta) {
        System.out.println("A "+nome+" atacou a planta "+planta.getNome());
    }
}
