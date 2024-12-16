package vivi;

import arquivoLerEEscrever.JardinagemFileManager;
import exceções.NaoComestivelException;
import exceções.PlantaNaoExisteException;
import exceções.PragaNaoExisteException;
import fungos.Cogumelo;
import plantas.CanaDeAçucar;
import plantas.Romã;
import plantas.Tomate;
import pragas.Infecção;
import pragas.Lagarta;

import java.util.Scanner;

public class Jardim {
    public static void main(String[] args) throws PlantaNaoExisteException, PragaNaoExisteException, NaoComestivelException {

        Jardinagem jardinagem = new Jardinagem();

        JardinagemFileManager fileManager = new JardinagemFileManager();

        try {
            JardinagemFileManager.carregandoJardim(jardinagem);
        } catch (NaoComestivelException| PlantaNaoExisteException | PragaNaoExisteException e) {
            System.err.println("Erro ao carregar o jardim: " + e.getMessage());
        }

        Scanner silly = new Scanner(System.in);

        while (true) {
            System.out.println("Menu inicial do jardim:");
            System.out.println("1 - Tomate");
            System.out.println("2 - Romã");
            System.out.println("3 - Cana de Açúcar");
            System.out.println("4 - Cogumelo");
            System.out.println("5 - Infecção");
            System.out.println("6 - Lagarta");
            System.out.println("7 - Mostrar Jardim");
            System.out.println("8 - Cuidar das Plantas");
            System.out.println("9 - Controlar Pragas");
            System.out.println("10 - Consumir Fungos");
            System.out.println("0 - Sair");

            int v = silly.nextInt();
            silly.nextLine();

            if (v == 1) {
                System.out.println("Digite o nome do tomate: ");
                String nomeTomate = silly.nextLine();
                if (nomeTomate.isEmpty()) {
                    throw new PlantaNaoExisteException("O nome do tomate não pode ser vazio");
                }
                System.out.println("Se encontra machucado?: ");
                boolean machucadoTomate = silly.nextBoolean();
                jardinagem.adicionaPlanta(new Tomate(nomeTomate, machucadoTomate));
                System.out.println();
            } else if (v == 2) {

                System.out.println("Digite o nome da romã: ");
                String nomeRoma = silly.nextLine();
                if (nomeRoma.isEmpty()) {
                    throw new NaoComestivelException("O nome da romã não pode ser vazio");
                }
                System.out.println("Se encontra machucado?: ");
                boolean machucadoRoma = silly.nextBoolean();
                jardinagem.adicionaPlanta(new Romã(nomeRoma, machucadoRoma));

            } else if (v == 3) {

                System.out.println("Digite o nome da cana de açúcar: ");
                String nomeCana = silly.nextLine();
                if (nomeCana.isEmpty()) {
                    throw new PlantaNaoExisteException("O nome da cana não pode ser vazio");
                }
                System.out.println("Se encontra machucado?: ");
                boolean machucadoCana = silly.nextBoolean();
                jardinagem.adicionaPlanta(new CanaDeAçucar(nomeCana, machucadoCana));

            } else if (v == 4) {
                try {
                    System.out.println("Digite o nome do cogumelo: ");
                    String nomeCogumelo = silly.nextLine();
                    System.out.println("O cogumelo se encontra umido?: ");
                    boolean umidoCogumelo = silly.nextBoolean();
                    System.out.println("O cogumelo é comestível?: ");
                    boolean comerCogumelo = silly.nextBoolean();
                    jardinagem.adicionaFungo(new Cogumelo(nomeCogumelo, umidoCogumelo, comerCogumelo));
                }catch (NaoComestivelException e){
                    System.err.println("erocorreu um erro:"+e.getMessage());
                }
            } else if (v == 5) {
                try {
                    System.out.println("Digite o nome da infecção: ");
                    String nomeInfeccao = silly.nextLine();
                    jardinagem.adicionaPraga(new Infecção(nomeInfeccao));
                } catch (PragaNaoExisteException e){
                    System.err.println("ocorreu um erro:"+e.getMessage());
                }
            } else if (v == 6) {
                try {
                    System.out.println("Digite o nome da lagarta: ");
                    String nomeLagarta = silly.nextLine();
                    jardinagem.adicionaPraga(new Lagarta(nomeLagarta));
                } catch (PragaNaoExisteException e){
                    System.err.println("ocorreu um erro:"+e.getMessage());
                }
            } else if (v == 7) {
                try {
                    jardinagem.mostrar();
                } catch (PlantaNaoExisteException | NaoComestivelException | PragaNaoExisteException e ) {
                    System.err.println("ocorreu um erro: " + e.getMessage());
                }
            } else if (v == 8) {
                try {
                    jardinagem.cuidarPlanta();
                } catch (PlantaNaoExisteException e) {
                    System.err.println("ocorreu um erro: " + e.getMessage());
                }
            } else if (v == 9) {
                try {
                    jardinagem.controlarPraga();
                } catch (PragaNaoExisteException e) {
                    System.err.println("ocorreu um erro: " + e.getMessage());
                }
            } else if (v == 10) {
                try {
                    jardinagem.consumirFungo();
                } catch (NaoComestivelException e) {
                    System.err.println("ocorreu um erro: " + e.getMessage());
                }
            } else if (v == 0) {
                System.out.println("fechando programa");

                System.out.println("Fechando programa");

                try {

                    fileManager.salvandoJardim(jardinagem);
                    System.out.println("Jardim salvo com sucesso!");

                    String conteúdoArquivo = fileManager.lendoJardim();
                    System.out.println("Conteúdo do jardim salvo no arquivo:");
                    System.out.println(conteúdoArquivo);

                } catch (Exception e) {
                    System.err.println("Erro ao salvar o jardim: " + e.getMessage());
                }
                break;
            } else {
                System.out.println("Opção invalida!");
            }
        }

    }

}

