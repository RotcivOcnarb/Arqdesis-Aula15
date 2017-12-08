package br.usjt.arqdesis.cliente;

import java.util.ArrayList;

/**
 * Created by rotci on 08/12/2017.
 */

public class ListaDados {

    static ListaDados instance;

    static{
        instance = new ListaDados();
    }

    ArrayList<String> lista;

    public static ListaDados getInstance(){
        return instance;
    }

    public int getIdOf(String nome){
       return lista.indexOf(nome);
    }

    private ListaDados(){
       lista = new ArrayList<String>();
       lista.add("Carlos Drummond de Andrade");
       lista.add("Manuel Bandeira");
       lista.add("Olavo Bilac");
       lista.add("Vinícius de Moraes");
       lista.add("Cecília Meireles");
       lista.add("Castro Alves");
       lista.add("Gonçalves Dias");
       lista.add("Ferreira Gullar");
       lista.add("Machado de Assis");
       lista.add("Mário de Andrade");
       lista.add("Cora Coralina");
       lista.add("Manoel de Barros");
       lista.add("João Cabral de Melo Neto");
       lista.add("Casimiro de Abreu");
       lista.add("Paulo Leminski");
       lista.add("Álvares de Azevedo");
       lista.add("Guilherme de Almeida");
       lista.add("Alphonsus de Guimarães");
       lista.add("Mário Quintana");
       lista.add("Gregório de Matos");
       lista.add("Augusto dos Anjos");
    }

    public ArrayList<String> getLista(){
        return lista;
    }

}
