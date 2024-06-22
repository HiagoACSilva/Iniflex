package classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    
    private BigDecimal salario;
    private String funcao;


    public Funcionario(String nome, LocalDate data_de_nascimento, BigDecimal salario, String funcao) {
        super(nome, data_de_nascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
