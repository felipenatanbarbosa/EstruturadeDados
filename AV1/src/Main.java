import java.util.Scanner;

public class Main {
    public static class No {
        public String nome;
        public int ficha;

        public No anterior;
        public No proximo;

        public No(String nome, int ficha) {
            this.nome = nome;
            this.ficha = ficha;

            this.anterior = null;
            this.proximo = null;
        }
    }

    public static class ListaDinamica {
        private No primeiro = null;
        private No ultimo = null;
        private int contador = 0;

        public void exibirTeste() {
            No aux = primeiro;

            while (aux != null) {
                System.out.println(aux.nome + " " + aux.ficha);
                aux = aux.proximo;
            }

            System.out.println();
        }

        public void adicionar(String nome, int ficha) {
            No novo = new No(nome, ficha);

            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            } else {
                ultimo.proximo = novo;
                ultimo = novo;
            }

            contador++;
        }

        public void remover(int posicao) {
            if (primeiro != null) {
                if (posicao == 0) {
                    primeiro = primeiro.proximo;
                } else {
                    No aux = primeiro;

                    for (int i = 0; i < posicao - 1; i++) {
                        aux = aux.proximo;
                    }

                    aux.proximo = aux.proximo.proximo;

                    if (posicao == tamanho() - 1) {
                        ultimo = aux;
                    }
                }
                contador--;
            }
        }

        public int tamanho() {
            return contador;
        }

        public void solvePar() {
            No aux = primeiro;
            int cont = 0;

            for (int k = 0; k < tamanho(); k++) {
                for (int i = 0; i < aux.ficha; i++) {
                    cont++;
                    if (cont == tamanho()) {
                        cont = -1;
                    }
                }
                remover(cont);
                aux = aux.proximo;
            }

        }


    }

    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        Scanner prompt = new Scanner(System.in);
        int qntInt = prompt.nextInt();
        int vezesRoda;

        while(qntInt != 0) {
            vezesRoda = qntInt;
            while(vezesRoda != 0) {
                lista.adicionar(prompt.next(), prompt.nextInt());
                vezesRoda--;
            }
            qntInt = prompt.nextInt(); //possibilidade do final.
        }
        lista.solvePar();

        System.out.println("Vencedor(a): ");
        lista.exibirTeste();
    }



}


