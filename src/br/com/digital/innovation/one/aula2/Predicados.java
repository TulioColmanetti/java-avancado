package br.com.digital.innovation.one.aula2;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
//        ** Predicate:
//        - tipo de interface funcional no Java;
//        - recebe parametro (tipo Generics = T) e retorna um BOOLEAN;
//        - tem que fornecer um return caso precise usar {} na implementação;
//        - método da interface para aplicar a funcionalidade = test;

//        Using Lambda Expression
        Predicate<String> estaVazio = str -> str.isEmpty();
        /*Using Method Reference
        Here is possible because it is just one operation and it is dealing directly with the received parameter*/
//        Predicate<String> estaVazio = String::isEmpty;
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Joao"));
    }
}
