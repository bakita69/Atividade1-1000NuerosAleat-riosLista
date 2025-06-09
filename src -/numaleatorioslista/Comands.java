package numaleatorioslista;

public class Comands {

    private class No {
        int valor;
        No anterior;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.anterior = null;
            this.proximo = null;
        }
    }

    private No inicio;
    private No fim;

    public void adicionarFim(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            novo.anterior = fim;
            fim = novo;
        }
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void imprimirDecrescente() {
        No atual = fim;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }

    private boolean ehPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero == 2) return true;
        if (numero % 2 == 0) return false;

        for (int i = 3; i * i <= numero; i += 2) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public void removerPrimos() {
        No atual = inicio;
        while (atual != null) {
            No proximo = atual.proximo;
            if (ehPrimo(Math.abs(atual.valor))) {
                if (atual == inicio && atual == fim) {
                    inicio = null;
                    fim = null;
                } else if (atual == inicio) {
                    inicio = atual.proximo;
                    if (inicio != null) inicio.anterior = null;
                } else if (atual == fim) {
                    fim = atual.anterior;
                    if (fim != null) fim.proximo = null;
                } else {
                    atual.anterior.proximo = atual.proximo;
                    atual.proximo.anterior = atual.anterior;
                }
            }
            atual = proximo;
        }
    }

    public void Acrescentar(int[] numeros) {
        boolean[] usados = new boolean[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            int menor = Integer.MAX_VALUE;
            int indice = -1;
            for (int j = 0; j < numeros.length; j++) {
                if (!usados[j] && numeros[j] < menor) {
                    menor = numeros[j];
                    indice = j;
                }
            }
            if (indice != -1) {
                usados[indice] = true;
                adicionarFim(numeros[indice]);
            }
        }
    }
}
