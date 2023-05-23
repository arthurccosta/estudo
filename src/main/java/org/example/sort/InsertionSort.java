package org.example.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int qtd = 10000;
        int[] vet = new int[qtd];

        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * qtd);
        }

        long start = System.currentTimeMillis();
        insertionSort(vet);
        long end = System.currentTimeMillis();

        System.out.println("Executado em = " + (end - start) + " ms");
    }

    public static void insertionSort(int[] vetor) {
        int j;
        int key;
        int i;

        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
    }
}
