public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica();

        lista.adicionar(2);
        lista.adicionar(1);
        lista.adicionar(24);

        System.out.println(lista.pesquisarElemento(3));
        System.out.println(lista.pesquisarIndice(8));
        System.out.println(lista.pesquisar(2));

        lista.exibir();
    }

}
