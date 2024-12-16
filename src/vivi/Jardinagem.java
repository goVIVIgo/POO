package vivi;

import classesA.Fungo;
import classesA.Planta;
import classesA.Praga;
import exceções.NaoComestivelException;
import exceções.PlantaNaoExisteException;
import exceções.PragaNaoExisteException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jardinagem {

    List<Planta> plantas;

    Set<Fungo> fungos;
    Set<Praga> pragas;

    public Jardinagem() {
        plantas = new ArrayList<>();
        fungos = new HashSet<>();
        pragas = new HashSet<>();
    }

    public void adicionaPlanta(Planta planta) throws PlantaNaoExisteException {
        if (planta.getNome() == null || planta.getNome().isEmpty()) {
            throw new PlantaNaoExisteException("O nome da planta não pode ser vazio.");
        }
        plantas.add(planta);
    }

    public void adicionaFungo(Fungo fungo) throws NaoComestivelException{
        if (fungo.getNome() == null || fungo.getNome().isEmpty()) {
            throw new NaoComestivelException("O nome da planta não pode ser vazio.");
        }
        fungos.add(fungo);
    }

    public void adicionaPraga(Praga praga) throws PragaNaoExisteException {
        if (praga.getNome() == null || praga.getNome().isEmpty()) {
            throw new PragaNaoExisteException("O nome da planta não pode ser vazio.");
        }
        pragas.add(praga);
    }

    public void cuidarPlanta() throws PlantaNaoExisteException {
        if (plantas.isEmpty()) {
            throw new PlantaNaoExisteException("Não há plantas para cuidar no jardim.");
        }
        for (Planta planta : plantas) {
            planta.cuidar();
        }
    }

    public void controlarPraga() throws PragaNaoExisteException {
        if (pragas.isEmpty()) {
            throw new PragaNaoExisteException("Não há pragas para controlar no jardim.");
        }
        for (Praga praga : pragas) {
            for(Planta planta : plantas){
                praga.atacarPlanta(planta);
            }
        }
    }

    public void consumirFungo() throws NaoComestivelException {
        if (fungos.isEmpty()) {
            throw new NaoComestivelException("Não há cogumelos para consumir no jardim.");
        }
        for (Fungo fungo : fungos) {
            fungo.comestivel();
        }
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public Set<Fungo> getFungos() {
        return fungos;
    }

    public Set<Praga> getPragas() {
        return pragas;
    }


    public void mostrar() throws PlantaNaoExisteException, NaoComestivelException, PragaNaoExisteException {
        if (plantas.isEmpty()) {
            throw new PlantaNaoExisteException("Nenhuma planta encontrada no jardim!");
        }

        if (fungos.isEmpty()) {
            throw new NaoComestivelException("Nenhum fungo encontrado no jardim!");
        }

        if (pragas.isEmpty()) {
            throw new PragaNaoExisteException("Nenhuma praga encontrada no jardim!");
        }

        System.out.println("Plantas no jardim:");
        for (Planta planta : plantas) {
            System.out.println(planta);
        }
        System.out.println("Fungos no jardim:");
        for (Fungo fungo : fungos) {
            System.out.println(fungo);
        }
        System.out.println("Pragas no jardim:");
        for (Praga praga : pragas) {
            System.out.println(praga);
        }

    }

}
