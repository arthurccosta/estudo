package org.example.search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(searchRecursive(array, 0, array.length - 1, 6));
        System.out.println(searchRecursive(array, 0, array.length - 1, 78));
        System.out.println(searchNotRecursive(array, 0, array.length - 1, 90));
    }

    private static int searchRecursive(int[] array, int menor, int maior, int key) {

        if (menor > maior) {
            return -1;
        }
        int media = (maior + menor) / 2;
        int valorMeio = array[media];

        if (valorMeio == key) {
            return media;

        } else if (valorMeio < key) {
            return searchRecursive(array, media + 1, maior, key);
        } else return searchRecursive(array, menor, media - 1, key);
    }

    private static int searchNotRecursive(int[] array, int menor, int maior, int key) {

        while (menor <= maior) {
            int media = (maior + menor) / 2;
            int valorMeio = array[media];

            if (valorMeio == key) {
                return media;
            } else if (array[media] < key) {
                menor = media + 1;
            } else
                maior = media - 1;

        }
        return -1;
    }
}

