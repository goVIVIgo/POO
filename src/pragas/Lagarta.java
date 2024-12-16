package pragas;

import classesA.Planta;
import classesA.Praga;

public class Lagarta extends Praga {
    public Lagarta(String nome) {
        super(nome);
    }

    @Override
    public void atacarPlanta(Planta planta) {
        System.out.println("A "+nome+" atacou a planta "+planta.getNome());
    }
}
