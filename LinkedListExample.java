import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Criando uma LinkedList de Strings
        LinkedList<String> linkedList = new LinkedList<>();

        // Adicionando elementos
        linkedList.add("Elemento 1");
        linkedList.add("Elemento 2");
        linkedList.add("Elemento 3");

        System.out.println("LinkedList inicial: " + linkedList);

        // Adicionando elementos em posições específicas
        linkedList.addFirst("Primeiro Elemento");
        linkedList.addLast("Último Elemento");

        System.out.println("Após adicionar elementos: " + linkedList);

        // Removendo elementos
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove("Elemento 2");

        System.out.println("Após remover elementos: " + linkedList);

        // Iterando sobre os elementos
        System.out.println("Iterando sobre os elementos:");
        for (String elemento : linkedList) {
            System.out.println(elemento);
        }
    }
}
