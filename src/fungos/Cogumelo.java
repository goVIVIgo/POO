package fungos;

import classesA.Fungo;
import exceções.FungoNaoExisteException;
import exceções.NaoComestivelException;
import exceções.NaoComestivelException;
import interfaces.Aguar;

public class Cogumelo extends Fungo implements Aguar {

    protected boolean comer;

    public Cogumelo(String nome, boolean umido, boolean comer) {
        super(nome,umido);
        this.comer = comer;
        this.umido = umido;
    }

    public void setComer(boolean comer) {
        this.comer = comer;
    }

    public boolean isComer() {
        return comer;
    }

    @Override
    public boolean comestivel() throws NaoComestivelException {
        if(!comer || !umido){
            throw new NaoComestivelException("nao ta podendo comer ainda");
        }
        comer = true;
        umido = true;
        System.out.println("o cogumelo esta comestivel");
        return true;
    }

    @Override
    public void aguar(double agua) throws FungoNaoExisteException {
        if(umido){
            System.out.println("os cogumelos devem receber "+agua+" por dia");
        }else{
            umido = true;
            System.out.println("os cogumelos foram umedecidos hoje");
        }
    }
}
