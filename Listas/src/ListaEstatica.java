public class ListaEstatica {
    private Object v[];
    private int contador;

    ListaEstatica() {
        v = new Object[10];
        contador = 0;
    }

    ListaEstatica(int n) {
        v = new Object[n];
        contador = 0;
    }

    public void adicionar(int valor) {
        if(contador != v.length) {
            v[contador] = valor;
            contador++;
        } else {
            // to do
        }

    }

    public void adicionar(int posicao, Object valor) {
        for(int i = contador; i > posicao; i--) {
            v[i + 1] = v[i];
        }

        v[posicao] = valor;
        contador++;
    }

    public int tamanho() {
        return contador;
    }

    public void remover(int posicao) {
        if(posicao != contador - 1) {
            for(int i = posicao; i < contador - 1; i++) {
                v[i] = v[i + 1];
            }
        }
        contador--;
    }

    public boolean pesquisar(Object valor) {
        for(int i = 0; i < contador; i++) {
            if(v[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public int pesquisarIndice(Object valor) {
        for(int i = 0; i < contador; i++) {
            if(v[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }

    public Object pesquisarElemento(int posicao) {
        if(posicao < contador) {
            return v[posicao];
        } else {
            return null;
        }
    }

    public void exibir() {
        for (int i = 0; i < contador; i++) {
            System.out.print(v[i] + " ");
        }

        System.out.println();
    }
}


















