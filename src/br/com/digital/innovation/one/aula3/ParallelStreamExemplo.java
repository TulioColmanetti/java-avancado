package br.com.digital.innovation.one.aula3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExemplo {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1,100000).forEach(num -> fatorial(num)); //Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Serial :: "+(fim-inicio));

        inicio = System.currentTimeMillis();
//        By deafult always use all threads available in the system processor minus one thread
//        The parallel() method creates smaller "sub-streams" that will run in parallel, at random order
//        Very important that the sub-streams do not depend of each other for execution
        IntStream.range(1,100000).parallel().forEach(num -> fatorial(num)); //Parallel
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel :: "+(fim-inicio));

        List<String> nomes = Arrays.asList("Joao", "Paulo", "Oliveira", "Santos");
//        short way of stream().parallel()
        nomes.parallelStream().forEach(System.out::println);
    }

    public static long fatorial(long num){
        long fat = 1;

        for (long i = 2; i <= num ; i++) {
            fat*=i;
        }
        return fat;
    }
}
