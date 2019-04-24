package service;

import domain.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaService {


    private List<Pessoa> listaPessoas;

    public PessoaService() {
        this.listaPessoas = buildPessoaList();
    }

    private static List<Pessoa> buildPessoaList(){

        List<Pessoa> lista = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            lista.add(new Pessoa("Nome"+i, 30+i, LocalDate.now()));
        }

        System.out.println("ORIGINAL: " + lista);
        return lista;
    }

    public void streamFilter(){

        System.out.print("FILTER: " + listaPessoas
                .stream()
                .filter(pessoa -> pessoa.getIdade() > 35)
                .collect(Collectors.toList()));
    }

    public void streamForeach(){
        listaPessoas.stream()
                .forEach(p -> System.out.println("FOREACH: "+ p.getNome()));
    }

    public void streamMap(){
        System.out.println("MAP: " + listaPessoas.stream()
                .map(Pessoa::getIdade)
                .collect(Collectors.toList()));
    }

    public void streamMapDois(){
        System.out.println("MAP2: " + listaPessoas
                .stream()
                .map(this::toUpperCase)
                // OU .map(p -> toUpperCase(p))
                .collect(Collectors.toList()));
    }

    public void findFirst(){
        System.out.println("FINDFIRST: " + listaPessoas
                .stream()
                .findFirst()
                .orElse(null));
    }

    public void findAnyWithNonNullValue(){
        System.out.println("FINDANY1: " + listaPessoas
                .stream()
                .filter(p -> "Nome5".equals(p.getNome()))
                .findAny()
                .orElse(null));
    }

    public void findAnyWithNullValue(){
        System.out.println("FINDANY2: " + listaPessoas
                .stream()
                .filter(p -> "Nome15".equals(p.getNome()))
                .findAny()
                .orElse(null));
    }
    private String toUpperCase(Pessoa pessoa){
        return pessoa.getNome().toUpperCase();
    }

}
