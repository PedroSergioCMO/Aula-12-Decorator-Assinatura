import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> pacotesAdicionados = new HashSet<>();
        Assinatura assinatura = null;
        
        System.out.println("====================================");
        System.out.println("  SISTEMA DE ASSINATURAS DE STREAMING");
        System.out.println("====================================\n");

        while (assinatura == null) {
            System.out.println("ESCOLHA SUA ASSINATURA BASE:");
            System.out.println("1 - Assinatura Base (R$9.99) - Assistir em um dispositivo");
            System.out.println("2 - Sair do sistema");
            
            System.out.print("\nDigite sua opção: ");
            int escolhaBase = scanner.nextInt();
            
            if (escolhaBase == 1) {
                assinatura = new AssinaturaBase();
                System.out.println("\n Assinatura base selecionada com sucesso!\n");
            } else if (escolhaBase == 2) {
                System.out.println("\nObrigado por visitar nosso serviço!");
                scanner.close();
                return;
            } else {
                System.out.println("\n Opção inválida! Por favor, digite 1 ou 2.\n");
            }
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("SUA ASSINATURA ATUAL:");
            System.out.println(assinatura.getDescricao());
            System.out.printf("VALOR ATUAL: R$%.2f\n\n", assinatura.getPreco());
            
            System.out.println("PACOTES ADICIONAIS DISPONÍVEIS:");
            System.out.println("1 - Multi-dispositivo (+R$19.99)");
            System.out.println("2 - Frete Grátis (+R$9.99)");
            System.out.println("3 - Caixa Surpresa (+R$29.99)");
            System.out.println("4 - Cartão Platinum (+R$49.99)");
            System.out.println("5 - Cash Back (+R$19.99)");
            System.out.println("0 - Finalizar contratação");
            
            System.out.print("\nDigite o número do pacote que deseja adicionar (0 para finalizar): ");
            int escolha = scanner.nextInt();
            
            if (escolha == 0) {
                continuar = false;
            } else if (escolha < 1 || escolha > 5) {
                System.out.println("\n Opção inválida! Por favor, digite um número entre 1 e 5.\n");
            } else if (pacotesAdicionados.contains(escolha)) {
                System.out.println("\n Você já adicionou este pacote! Escolha outro.\n");
            } else {
                switch (escolha) {
                    case 1:
                        assinatura = new PacoteMultiDispositivo(assinatura);
                        break;
                    case 2:
                        assinatura = new PacoteFreteGratis(assinatura);
                        break;
                    case 3:
                        assinatura = new PacoteCaixaSurpresa(assinatura);
                        break;
                    case 4:
                        assinatura = new PacoteCartaoPlatinum(assinatura);
                        break;
                    case 5:
                        assinatura = new PacoteCashBack(assinatura);
                        break;
                }
                pacotesAdicionados.add(escolha);
                System.out.println("\n Pacote adicionado com sucesso!\n");
            }
        }
        
        System.out.println("\n====================================");
        System.out.println("         RESUMO DA ASSINATURA");
        System.out.println("====================================");
        System.out.println(assinatura.getDescricao());
        System.out.println("------------------------------------");
        System.out.printf("VALOR TOTAL: R$%.2f\n", assinatura.getPreco());
        System.out.println("====================================");
        
        System.out.println("\nObrigado por assinar nosso serviço!");
        scanner.close();
    }
}