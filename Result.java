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
     * Complete the 'romanizer' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static List<String> romanizer(List<Integer> numbers) {
    // Write your code here
    System.out.println(numbers);
    
    Integer teste = 1893;
    String romanizado = getNMil(teste);
    System.out.println(romanizado);
    teste = teste - removerMilhar(romanizado);
    if (teste > 900) {
        String resto = getNMil(teste);
        teste = teste - removerMilhar(resto);
        System.out.println("resto vale " + resto);
        romanizado += resto;
    }
    System.out.println("romanizado agora com " + romanizado);
    
    System.out.println("teste com " + teste);
    String letraD = getNQuinhentos(teste);
    System.out.println("quinhentos vale " + letraD);
    teste = teste - removerSesc(letraD);
    
    System.out.println("teste com " + teste);
    String letraC = getCentena(teste);
    System.out.println("centena vale " + letraC);
    teste = teste - removerCentena((letraC));
    
    System.out.println("teste com " + teste);
    String letraL = get50(teste);
    System.out.println("cinquenta vale " + letraL);
    
    System.out.println("Finalizado");
    return null;

    }
    
    public String doRoman(Integer i) {
        
        return null;
    }
    
    public static String getNMil(Integer numero) {
        String retorno = "";
        Integer vezes = numero / 1000;
        for (int i=0; i< vezes; i++) {
            retorno += "M";
        }
        if (numero < 1000 && numero > 899) {
            retorno = "CM";
        }
        return retorno;
    }
    
    public static Integer removerMilhar(String milhar) {
        Integer retorno = 0;
        if (milhar.equals(("CM"))) {
            retorno = 900;
        } else {
            retorno = 1000 * milhar.length();
        }
        return retorno;
    }
    
    public static String getNQuinhentos(Integer numero) {
        if (numero < 500 && numero > 399) {
            return "CD";
        }
        String retorno = "";
        Integer vezes = numero / 500;
        for (int i=0; i< vezes; i++) {
            retorno += "D";
        }
        return retorno;
    }

    public static Integer removerSesc(String quinha) {
        Integer retorno = 0;
        if (quinha.equals(("CD"))) {
            retorno = 400;
        } else {
            retorno = 500 * quinha.length();
        }
        return retorno;
    }

    public static String getCentena(Integer numero) {
        if (numero < 100 && numero > 89) {
            return "XC";
        }
        String retorno = "";
        Integer vezes = numero / 100;
        for (int i=0; i< vezes; i++) {
            retorno += "C";
        }
        return retorno;
    }
    
    public static Integer removerCentena(String cento) {
        Integer retorno = 0;
        if (cento.equals(("XC"))) {
            retorno = 90;
        } else {
            retorno = 100 * cento.length();
        }
        return retorno;
    }
    
    public static String get50(Integer numero) {
        if (numero < 50 && numero > 39) {
            return "XL";
        }
        String retorno = "";
        if (numero >= 50) {
            retorno = "L";
        }
        return retorno;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.romanizer(numbers);

/*
        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );
*/

        bufferedReader.close();
        bufferedWriter.close();
    }
}
