package classes;


import java.time.LocalDate;

public class Pessoa {
    //Variaveis
    private String nome;
    private LocalDate data_de_nascimento;

    //Construtor
    public Pessoa(String nome, LocalDate data_de_nascimento) {
        this.nome = nome;
        this.data_de_nascimento = data_de_nascimento;
    }

    //Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_de_nascimento() {
        return this.data_de_nascimento;
    }

    public void setData_de_nascimento(LocalDate data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }
}
