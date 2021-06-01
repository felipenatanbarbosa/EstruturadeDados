import java.util.List;

public class ListaDinamica {
    private No primeiro;
    private No ultimo;
    private int contador;

    public ListaDinamica() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void adicionar(int valor) {
        No novo = new No(valor);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }

        contador++;
    }

    public void adicionar(int posicao, int valor) {
        No novo = new No(valor);

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


    public int tamanho() {
        return contador;
    }

    public void remover(int posicao) {
        if(primeiro != null) {
            if(posicao == 0) {
                primeiro = primeiro.proximo;
            } else {
                No aux = primeiro;

                for(int i = 0; i < posicao - 1; i++) {
                    aux = aux.proximo;
                }

                aux.proximo = aux.proximo.proximo;

                if(posicao == tamanho() - 1) {
                    ultimo = aux;
                }
            }

            contador --;
        }
    }



    public Object pesquisarElemento(int posicao) {
        No aux = primeiro;

        for(int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }

        return aux.dado;
    }

    public void exibir() {
        No aux = primeiro;

        while(aux != null) {
            System.out.print(aux.dado + " ");
            aux = aux.proximo;
        }

        System.out.println();
    }
}

