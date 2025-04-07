import java.util.TreeMap;

public class TreeMapExemplo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "C");
        treeMap.put(1, "A");
        treeMap.put(2, "B");

        System.out.println("TreeMap: " + treeMap); // Ordenado pelas chaves
    }
}
