package adotest;

/**
 *
 * @author Gabriel Estevam
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila();
        try (Scanner scanner = new Scanner(System.in)) {
            String opcao = "";
            
            while (!opcao.equals("4")) {
                System.out.println("\nSelecione a opcao:");
                System.out.println("1. Adicionar paciente a fila");
                System.out.println("2. Atender proximo paciente");
                System.out.println("3. Consultar fila");
                System.out.println("4. Sair");
                
                opcao = scanner.nextLine();
                
                switch (opcao) {
                    case "1" -> {
                        System.out.println("Digite o nome do paciente:");
                        String nome = scanner.nextLine();
                        
                        System.out.println("O paciente e preferencial? (s/n)");
                        char preferencial = scanner.nextLine().charAt(0);
                        
                        fila.enfileirar(new Pacientes(nome, preferencial == 's'));
                        
                        System.out.println("O Paciente foi Adicionado com sucesso!");
                    }
                    case "2" -> {
                        Pacientes pacienteatual = fila.desenfileirar();
                        if (pacienteatual != null) {
                            System.out.println("Próximo paciente a ser atendido: " + pacienteatual.getNome() + ". Preferencial: " + (pacienteatual.isPreferencial() ? "sim" : "nao"));
                        } else {
                            System.out.println("Nao ha pacientes na fila.");
                        }
                    }
                    case "3" -> {
                        System.out.println("Consulta da fila:");
                        fila.consultarFila();
                    }
                    case "4" -> System.out.println("Saindo da aplicacao...");
                    default -> System.out.println("Opção invalida. Tente novamente.");
                }
            }
        }
    }
}
