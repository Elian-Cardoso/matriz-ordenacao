import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = sc.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = sc.nextInt();

        Matriz m = new Matriz(linhas, colunas);

        System.out.println("Escolha o tipo de preenchimento:");
        System.out.println("1 - Manual");
        System.out.println("2 - Automático");
        int opc = sc.nextInt();

        if (opc == 1) {
            m.preencherManual(sc);
        } else {
            m.preencherAutomatico();
        }

        System.out.println("\nMatriz Original:");
        m.exibir();

        m.ordenarPorLinha();
        System.out.println("\nMatriz Ordenada por Linha:");
        m.exibir();

        m.ordenarPorColuna();
        System.out.println("\nMatriz Ordenada por Coluna:");
        m.exibir();

        m.ordenarMatrizCompleta();
        System.out.println("\nMatriz Ordenada como Vetor:");
        m.exibir();

        sc.close();
    }
}
