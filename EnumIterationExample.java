public class EnumIterationExample {
    enum DiaDaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }

    public static void main(String[] args) {
        // Iterando sobre os valores do enum
        for (DiaDaSemana dia : DiaDaSemana.values()) {
            System.out.println("Dia: " + dia);
        }
    }
}
