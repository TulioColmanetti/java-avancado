package br.com.digital.innovation.one.aula2;

import java.util.function.Supplier;

public class Suplidores {
    public static void main(String[] args) {
//        ** Supplier:
//        - tipo de interface funcional no Java;
//        - apenas retorna qualquer coisa especificada (Generics = T), NAO recebe nenhum parametro;
//        - método da interface para aplicar a funcionalidade = get;

//        Using Lambda Expression
        Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
//        Using Method Reference - to instantiate an object use the new method
        Supplier<Pessoa> instanciaPessoa2 = Pessoa::new;
//        When using println with objects, it will call the toString() method by default
        System.out.println(instanciaPessoa.get());
        System.out.println(instanciaPessoa2.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "joao";
        idade = 23;
    }

    /*Best practice to always overwrite, because println call it by default.
    If toString() is not present, the method from Object class will be called instead,
    returning the reference of this object in memory (address)*/
    @Override
    public String toString() {
        return String.format("nome : %s, idade: %d",nome,idade) ;
    }
}
