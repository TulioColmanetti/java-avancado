package br.com.digital.innovation.one.aula2;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
//        ** Consumer:
//        - tipo de interface funcional no Java;
//        - apenas recebe parametro (tipo Generics = T), não tem retorno (não precisa passar return);
//        - utilizar o parametro da forma que ele foi recebido;
//        - método da interface para aplicar a funcionalidade = accept;

//        Using Method Reference (supressing parameter, compiler already understands it under the hood)
        Consumer<String> imprimirUmaFrase = System.out::println;
//        Using Lambda Expression
        imprimirUmaFrase.accept("Hello World");
        Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);
        imprimirUmaFrase2.accept("Hello World");
    }
}
