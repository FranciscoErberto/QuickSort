/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;

/**
 *
 * @author Erberto Sousa
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] v = new int[10]; //cria o vetor com 100 posições
        for (int i = 0; i < v.length; i++) {
            int rnd = (int) (1 + Math.random() * 100); // gera um valor randomico de 0.0 ate menores q 1.0, multiplica por 100 e soma 1. Convertendo o resultado para int.
            v[i] = rnd; // atribui o valor a cada indice do vetor
        }
        System.out.println(Arrays.toString(v));
        quickSort(v, 0, v.length - 1);
        System.out.println(Arrays.toString(v));
    }

    private static void quickSort(int[] v, int i, int j) {
        if (i < j) {

            int k = dividir(v, i, j);
            quickSort(v, i, k - 1);
            quickSort(v, k + 1, j);
        }

    }

    private static int dividir(int[] v, int i, int j) {

        int p = i, q = j;

        while (p < q) {
            while (p < i && v[p] <= v[i]) p++;
            while (q > j && v[q] >= v[i]) q--; 
            if (p < q) {
                inverte(v, p, q);
                p++;
                q--;

            }
        }
        inverte(v, i, q);
        return q;
    }

    private static void inverte(int[] v, int p, int q) {

        int aux = v[p];
        v[p] = v[q];
        v[q] = aux;
    }

}
