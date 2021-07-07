package br.com.digital.innovation.one.aula2;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
//        ** Function:
//        - tipo de interface funcional no Java;
//        - recebe parametro (tipo Generics = T) e retorna algo qualquer;
//        - tem que fornecer um return caso precise usar {} na implementação;
//        - método da interface para aplicar a funcionalidade = apply;

        Function<String,String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
//        Since a calculation is done with the received parameters (*2), not possible to use Method Reference here, two distinct operations
        Function<String,Integer> converterStringParaInteiroECalcularODobro = string -> Integer.valueOf(string) * 2;
        System.out.println(retornarNomeAoContrario.apply("joao"));
        System.out.println(converterStringParaInteiroECalcularODobro.apply("20"));
    }
}
