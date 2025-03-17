import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

/*
 * Complete the 'sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

public static int sockMerchant(int n, List<Integer> ar) {
// Write your code here

    int k = ar.size();
    System.out.println("Lista com " + k);
    Map<Integer, Integer> mapa = new HashMap<>();
    for (int numero: ar) {
        mapa.put(numero, numero);
    }
    //int iterat = mapa.entrySet().iterator();
    List<Integer> unicos = new ArrayList<>();
    for(Integer num: mapa.values()){
        unicos.add(num);
    }

    Integer resposta = 0;
    for (int unico: unicos) {
        Integer nPares = qtdPar(ar, unico);
        String resultado = "Numero de pares para " + unico + " vale " + nPares;
        System.out.println(resultado);
        resposta += nPares;
    }

    return resposta;
}

private static Integer qtdPar(List<Integer> ar, Integer numero) {
    Integer contagem = 0;
    for (Integer num: ar) {
        //System.out.println("verificando " + numero);
        if (num == numero) {
            contagem++;
        }
        //System.out.println("temos " + contagem);
    }
    Integer resultado = contagem / 2;
    //System.out.println("retornando " + resultado);
    return resultado;
}


}

public class Solutis {
public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

// input 6
// input 10 20 10 20 20 50 20 10

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.sockMerchant(n, ar);

    // bufferedWriter.write(String.valueOf(result));
    // bufferedWriter.newLine();

    bufferedReader.close();
    // bufferedWriter.close();
}


}