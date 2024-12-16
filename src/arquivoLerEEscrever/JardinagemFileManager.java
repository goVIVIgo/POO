package arquivoLerEEscrever;

import classesA.Fungo;
import classesA.Planta;
import classesA.Praga;
import exceções.NaoComestivelException;
import exceções.PlantaNaoExisteException;
import exceções.PragaNaoExisteException;
import fungos.Cogumelo;
import plantas.CanaDeAçucar;
import plantas.Romã;
import plantas.Tomate;
import pragas.Infecção;
import pragas.Lagarta;
import vivi.Jardinagem;

import java.io.*;

public class JardinagemFileManager {

    private static final String JARDIM_VIVI = "C:\\Users\\engal\\OneDrive\\Documentos\\Jardim_VIVI.txt";

    public static void carregandoJardim(Jardinagem jardinagem) throws PragaNaoExisteException, PlantaNaoExisteException, NaoComestivelException{
        try (BufferedReader br = new BufferedReader(new FileReader(JARDIM_VIVI))){
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("Planta")) {
                    int indexNome = linha.indexOf("Planta" + "Plnata".length());
                    int indexVirgula = linha.indexOf(",", indexNome);
                    String nome = linha.substring(indexNome, indexVirgula).trim();

                    int indexMachucado = linha.indexOf("Machucado" + "Macahucado".length());
                    String machucadoStr = linha.substring(indexMachucado).trim();
                    boolean machucado = machucadoStr.equalsIgnoreCase("true");

                    Planta planta = null;

                    if (nome.equals("Tomate")) {
                        planta = new Tomate(nome, machucado);
                    } else if (nome.equals("Romã")) {
                        planta = new Romã(nome, machucado);
                    } else if (nome.equals("Cana de Açucar")) {
                        planta = new CanaDeAçucar(nome, machucado);
                    }

                    if (planta == null) {
                        throw new PlantaNaoExisteException("planta nao encontrada: " + nome);
                    }

                    jardinagem.adicionaPlanta(planta);

                } else if (linha.startsWith("Fungo")) {
                    int indexNome = linha.indexOf("Fungo") + "Fungo".length();
                    int indexVirgula = linha.indexOf(",", indexNome);
                    String nome = linha.substring(indexNome, indexVirgula).trim();

                    int indexUmido = linha.indexOf("Umido") + "Úmido".length();
                    int indexVirgulaUmido = linha.indexOf(",", indexUmido);
                    String umidoStr = linha.substring(indexUmido, indexVirgulaUmido).trim();
                    boolean umido = umidoStr.equals("true");

                    int indexComer = linha.indexOf("Comestível") + "Comestivel".length();
                    String comerStr = linha.substring(indexComer).trim();
                    boolean comer = comerStr.equals("true");

                    Fungo fungo = null;

                    if (nome.equals("Cogumelo")) {
                        fungo = new Cogumelo(nome, umido, comer);
                    }

                    if(fungo == null){
                        throw new NaoComestivelException("fungo nao encontrado: " + nome);
                    }

                    jardinagem.adicionaFungo(fungo);

                } else if (linha.startsWith("Praga: ")) {
                    int indexNome = linha.indexOf("Praga") + "Praga".length();
                    String nome = linha.substring(indexNome).trim();

                    Praga praga = null;

                    if (nome.equals("Lagarta")) {
                        praga = new Lagarta(nome);
                    } else if (nome.equals("Infecção")) {
                        praga = new Infecção(nome);
                    }

                    if(praga == null){
                        throw new PragaNaoExisteException("praga nao encontrada: " + nome);
                    }

                    jardinagem.adicionaPraga(praga);
                }
            }
            System.out.println("Jardim carregado com sucesso!");
        } catch (IOException | PlantaNaoExisteException | NaoComestivelException | PragaNaoExisteException e) {
            System.err.println("Erro ao carregar o jardim: " + e.getMessage());
        }
    }

    public static final void salvandoJardim(Jardinagem jardiganem) throws IOException, NaoComestivelException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JARDIM_VIVI))){
            for (Planta planta : jardiganem.getPlantas()) {
                writer.write("Planta " + planta.getNome() + ", Machucado " + planta.isMachucada());
                writer.newLine();
            }

            for (Fungo fungo : jardiganem.getFungos()) {
                writer.write("Fungo: " + fungo.getNome() + ", Úmido: " + fungo.isUmido() + ", Comestível: " +fungo.comestivel());
                writer.newLine();
            }

            for(Praga praga : jardiganem.getPragas()){
                writer.write("Praga: " + praga.getNome());
                writer.newLine();
            }

            System.out.println("Jardim salvo com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao salvar o jardim: " + e.getMessage());
        }
    }

    public String lendoJardim() throws IOException{
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(JARDIM_VIVI))){
            String linha;

            while( (linha = reader.readLine()) != null){
                sb.append(linha).append("\n");
            }

        } catch (IOException e) {
            System.err.println("Erro ao lendar o jardim: " + e.getMessage());
            throw e;
        }
        return sb.toString();
    }

}