import java.util.Random;

public class Matriz {
    private int[][] matriz;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matriz = new int[linhas][colunas];
    }

    // Preenchimento manual (Scanner passado da Main)
    public void preencherManual(java.util.Scanner sc) {
        System.out.println("Preenchendo a matriz manualmente:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Digite valor para [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    // Preenchimento automático com números aleatórios
    public void preencherAutomatico() {
        Random rand = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = rand.nextInt(100); // 0 a 99
            }
        }
    }

    // Remover elemento (substituir por 0)
    public void removerElemento(int linha, int coluna) {
        if (linha < linhas && coluna < colunas) {
            matriz[linha][coluna] = 0;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    // Exibir matriz
    public void exibir() {
        System.out.println("Matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Ordenar por linha usando Bubble Sort
    public void ordenarPorLinha() {
        for (int i = 0; i < linhas; i++) {
            bubbleSort(matriz[i]);
        }
    }

    // Ordenar por coluna usando Bubble Sort
    public void ordenarPorColuna() {
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = matriz[i][j];
            }
            bubbleSort(coluna);
            for (int i = 0; i < linhas; i++) {
                matriz[i][j] = coluna[i];
            }
        }
    }

    // Ordenar toda a matriz como vetor usando Merge Sort
    public void ordenarMatrizCompleta() {
        int[] vetor = new int[linhas * colunas];
        int k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[k++] = matriz[i][j];
            }
        }

        mergeSort(vetor, 0, vetor.length - 1);

        k = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = vetor[k++];
            }
        }
    }

    // Bubble Sort iterativo
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    // Merge Sort recursivo
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = array[left + i];
        for (int j = 0; j < n2; j++) R[j] = array[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < n1) array[k++] = L[i++];
        while (j < n2) array[k++] = R[j++];
    }
}
