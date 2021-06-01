import java.util.Scanner;

public class test {
    public static class NoString {
        public String dado;
        public NoString anterior;

        public NoString proximo;

        public NoString(String dado){
            this.dado = dado;
            this.anterior=null;
            this.proximo=null;
        }
    }

    public static class ListaDinamicaOrdenadaString {
        private NoString primeiro = null;
        private NoString ultimo = null;
        private int cont = 0;

        public ListaDinamicaOrdenadaString() {
        }

        public void push(String valor) {
            NoString novo = new NoString(valor);
            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            } else if (novo.dado.compareTo(primeiro.dado) < 0) {
                novo.proximo = primeiro;
                primeiro = novo;
            } else if (valor.compareTo(ultimo.dado) >= 0) {
                ultimo.proximo = novo;
                ultimo = novo;
            } else {
                NoString aux = primeiro;

                while (aux.proximo.dado.compareTo(valor) < 0) {
                    aux = aux.proximo;

                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;
            }
            cont++;
        }


        /*



        public int searchIndex(int valor) {
            if (valor >= this.length()) {
                System.out.println("It's not possible to get a Object from a position that is not on the list.\nSearch Error. Invalid Position.");
                System.exit(1);
                return -1;
            } else {
                No aux = this.primeiro;

                for(int i = 0; i < valor; ++i) {
                    aux = aux.proximo;
                }

                return aux.dado;
            }
        }


    */
        public Object searchElement(int posicao) {
            if (posicao >= this.cont) {
                System.out.println("Invalid position. This position is not on the list.");
                System.exit(1);
                return -1;
            } else {
                NoString aux = this.primeiro;

                for(int i = 0; i < posicao; ++i) {
                    aux = aux.proximo;
                }

                return aux.dado;
            }
        }
        public void pop(int posicao) {
            NoString aux = this.primeiro;
            if (this.length() > 1) {
                if (posicao == 0) {
                    this.primeiro = aux.proximo;
                } else {
                    for(int i = 0; i < posicao - 1; ++i) {
                        aux = aux.proximo;
                    }

                    if (posicao == this.length() - 1) {
                        this.ultimo = aux;
                        aux.proximo = null;
                    } else {
                        aux.proximo = aux.proximo.proximo;
                    }
                }
            } else if (posicao == 0) {
                this.primeiro = null;
                this.ultimo = null;
            }

            --this.cont;
        }
        public boolean search(String valor) {
            for (NoString aux = this.primeiro; aux != null; aux = aux.proximo) {
                if (aux.dado.equals(valor)) {
                    return true;
                }
            }

            return false;
        }

        public int length() {
            return this.cont;
        }

        public void show() {
            int i = 0;
            for (NoString aux = this.primeiro; aux != null; aux = aux.proximo) {
                if(!(length()-1 == i)) {
                    System.out.print(aux.dado + " ");

                }else{
                    System.out.println(aux.dado);
                }
                i++;
            }

        }
    }

    public static class ListaEstatica {
        private Object v[];
        private int contador;

        public ListaEstatica() {
            v = new Object[10];
            contador = 0;
        }

        public ListaEstatica(int n) {
            v = new Object[n];
            contador = 0;
        }

        public void adicionar(Object n) {

            if (contador >= v.length) {
                ampliarLista();
            }

            this.v[contador] = n;
            contador++;
        }
        private void ampliarLista() {
            Object[] aux = new Object[(int) (this.v.length * 1.5)];

            for (int i = 0; i < this.v.length; i++) {
                aux[i] = v[i];
            }

            this.v = aux;
        }
        public void adicionar ( int posicao, Object valor){
            if (contador != v.length) {
                if (posicao <= contador) {
                    for (int i = contador; i > posicao; i--) {
                        v[i] = v[i - 1];
                    }
                    v[posicao] = valor;

                } else {
                    System.out.println("Posição Inválida");
                }
            } else {
                System.out.println("Vetor Sem Espaço");
            }
            contador++;
        }
        public int tamanho () {
            return contador;

        }
        public boolean pesquisar ( Object valor){
            for (int i = 0; i < contador; i++) {
                if (v[i].equals(valor)) {
                    return true;
                }
            }

            return false;
        }
        public int pesquisarIndice ( Object valor){
            for (int i = 0; i < contador; i++) {
                if (v[i].equals(valor)) {
                    return i;
                }
            }

            return -1;

        }
        public Object pesquisarElemento ( int posicao) throws Exception {
            if (posicao < contador) {
                return v[posicao];
            }else{
                return null;
            }
        }
        public void remover ( int posicao) throws Exception {
            if (posicao < contador) {
                for (int i = posicao; i < contador - 1; i++) {
                    v[i] = v[i + 1];
                }
                contador--;
            } else {
                throw new Exception("Posição Inválida");
            }
        }
        public void exibir () {
            for (int i = 0; i < contador; i++) {
                System.out.print(v[i] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) throws Exception {

        Scanner prompt = new Scanner(System.in);
        ListaDinamicaOrdenadaString list = new ListaDinamicaOrdenadaString();
        ListaEstatica signals = new ListaEstatica();
        int bonzinho = 0;
        int cria = 0;
        int x = prompt.nextInt();
        for(int i = 0;i < x ;i++){
            signals.adicionar(prompt.next());
            list.push(prompt.next());
        }
        for(int i = 0;i <x;i++){

            System.out.println(list.searchElement(i));
            if("+".equals(signals.pesquisarElemento(i))){
                bonzinho++;
            }else{
                cria++;
            }

        }
        System.out.println("Se comportaram: "+bonzinho+" | Nao se comportaram: "+cria);
    }
}
