import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static class No {
        public String nome;

        public No proximo;

        public No(String nome) {
            this.nome = nome;

            this.proximo = null;
        }
    }

    public static class ListaDinamica {
        private No primeiro = null;
        private No ultimo = null;
        private int contador = 0;

        public int tamanho() {
            return contador;
        }

        public void exibirTeste() {
            No aux = primeiro;

            while (aux != null) {
                System.out.print(aux.nome + " ");
                aux = aux.proximo;
            }

            System.out.println();
        }

        public void adicionar(String nome) {
            No novo = new No(nome);

            if (primeiro == null) {
                primeiro = novo;
            } else {
                ultimo.proximo = novo;
            }
            ultimo = novo;

            contador++;
        }

        public void adicionar(int posicao, String nome) {
            No novo = new No(nome);

            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            } else if (posicao == 0) {
                novo.proximo = primeiro;
                primeiro = novo;
            } else if (posicao == tamanho()) {
                ultimo.proximo = novo;
                ultimo = novo;
            } else {
                No aux = primeiro;

                for (int i = 0; i < posicao - 1; i++) {
                    aux = aux.proximo;
                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }

            contador++;
        }

        public void inserir(String[] insert) {
            for(int i = 0; i < insert.length; i++) {
                adicionar(insert[i]);
            }
        }

        public int pesquisar(String nome) {
            No aux = primeiro;
            int cont = 0;
            while(aux.proximo != null) {
                aux = aux.proximo;
                cont ++;

                if(aux.nome.equals(nome)) {
                    return cont;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        ListaDinamica lista = new ListaDinamica();

        String[] entrada = prompt.nextLine().split(" "); //primeira entrada
        lista.inserir(entrada);

        entrada = prompt.nextLine().split(" ");   //segunda entrada

        String disc = prompt.next();

        if(lista.pesquisar(disc) != -1) {
            for(int i = 0; i < entrada.length; i++) {
                lista.adicionar(lista.pesquisar(disc), entrada[i]);
            }
        } else if(disc.equals("nao")) {
            lista.inserir(entrada);
        }

        lista.exibirTeste();

    }

}
