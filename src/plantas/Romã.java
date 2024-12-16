package plantas;

import classesA.Planta;
import exceções.PlantaNaoExisteException;
import interfaces.Aguar;
import interfaces.Manutenção;
import interfaces.Podar;

public class Romã extends Planta implements Podar, Manutenção, Aguar {
    public Romã(String nome, boolean machucada) {
        super(nome, machucada);
    }

    @Override
    public void cuidar() throws PlantaNaoExisteException {
        if(!machucada){
            throw new PlantaNaoExisteException("a planta "+ nome + " ja foi medicada hoje, papai");
        }
        machucada = true;
        System.out.println("a planta " + nome + " esta sendo tratada");
    }

    @Override
    public void colher(int frutos) {
        System.out.println("foram colhidos "+ frutos);
    }

    @Override
    public void podar() {

    }

    @Override
    public void manutencao() throws PlantaNaoExisteException {

    }

    @Override
    public void aguar(double agua) {

    }
}
