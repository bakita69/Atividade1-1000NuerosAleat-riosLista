package numaleatorioslista;

import java.util.Random;

public class Principal {

    public static void main(String[] args) {

        int[] numeros = new int[1000];
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            numeros[i] = random.nextInt(19999) - 9999;
        }

        Comands lista = new Comands();

        int posicaoMenor[] = new int[1000];
        int iterador = 0;

        while (iterador < 1000) {
            int j = 0;

            while (verifica(posicaoMenor, j, iterador)) {
                j++;
            }

            int menor = numeros[j];
            int indice = j;

            for (int i = 0; i < 1000; i++) {
                if (verifica(posicaoMenor, i, iterador)) {
                    continue;
                }

                if (numeros[i] < menor) {
                    menor = numeros[i];
                    indice = i;
                }
            }

            posicaoMenor[iterador] = indice;
            lista.adicionarFim(menor);
            iterador++;
        }

        System.out.println("Vetor gerado:");
        for (int i = 0; i < 1000; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println("\n\nLista em ordem crescente:");
        lista.imprimir();

        System.out.println("\nLista em ordem decrescente:");
        lista.imprimirDecrescente();

        lista.removerPrimos();

        System.out.println("\nLista sem números primos:");
        lista.imprimir();
    }

    private static boolean verifica(int[] posicaoMenor, int valor, int ate) {
        for (int i = 0; i < ate; i++) {
            if (posicaoMenor[i] == valor) {
                return true;
            }
        }
        return false;
    }
}
