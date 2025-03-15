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

     //System.out.println("iniciando...");

    public static List<String> romanizer(List<Integer> numbers) {
    // Write your code here
    System.out.println(numbers);
    
    Integer teste = 1888;
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
    if (teste > 90) {
        String resto = getCentena(teste);
        System.out.println("teste tratado com " + teste);
        teste = teste - removerCentena(resto);
        letraC += resto;
        System.out.println("letraC ajustada para " + letraC);
    }
    
    System.out.println("teste com " + teste);
    String letraL = get50(teste);
    System.out.println("cinquenta vale " + letraL);
    teste = teste - remover50(letraL);
    System.out.println("teste com " + teste);
    if (teste >= 40) {
        String resto = get50(teste);
        System.out.println("resto vale " + resto);
        letraL += resto;
        System.out.println("letraL ficou " + letraL);
    }

    System.out.println("teste com " + teste);
    String letraX = getDezena(teste);
    System.out.println("Dezena é " + letraX);
    teste = teste - removerDezena(letraX);

    System.out.println("teste com " + teste);
    String letraV = getCinco(teste);
    System.out.println("Cinco = " + letraV);
    teste = teste - removerCinco(letraV);
    
    System.out.println("teste com " + teste);
    
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

    public static Integer remover50(String s50) {
        Integer retorno = 0;
        if (s50.equals(("XL"))) {
            retorno = 40;
        } 
        if (s50.startsWith("L")) {
            retorno = 50;
        }
        return retorno;
    }

    public static String getDezena(Integer numero) {
        if (numero == 9) {
            return "IX";
        }
        String retorno = "";
        Integer vezes = numero / 10;
        for (int i=0; i< vezes; i++) {
            retorno += "X";
        }
        return retorno;
    }

    public static Integer removerDezena(String dez) {
        Integer retorno = 0;
        if (dez.equals(("IX"))) {
            retorno = 9;
        } else {
            retorno = 10 * dez.length();
        }
        return retorno;
    }

    public static String getCinco(Integer numero) {
        if (numero == 4) {
            return "IV";
        }
        if (numero == 9) {
            return "IX";
        }
        if (numero >= 5) {
            return "V";
        }
        return "";
    }

    public static Integer removerCinco(String cinco) {
        Integer retorno = 0;
        if (cinco.equals(("IV"))) {
            retorno = 4;
        } 
        if (cinco.equals("V")) {
            retorno = 5;
        }
        return retorno;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("iniciando...");
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());


        /* 
        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        */

        Integer[] array = {1962, 2440,};

        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(array));

        List<String> result = Result.romanizer(numbers);

        System.out.println(result);

/*
        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );
*/

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}

