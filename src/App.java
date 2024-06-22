
import classes.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class App {
    public static void main(String[] args) throws Exception {

        //3.1 Criando a lista de funcionarios
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        //3.1 Adicionando todos os funcionarios para a lista dinâmica
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990,5,18), new BigDecimal(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,18), new BigDecimal(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,18), new BigDecimal(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,18), new BigDecimal(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,18), new BigDecimal(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,18), new BigDecimal(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,18), new BigDecimal(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,18), new BigDecimal(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal(2799.93), "Gerente"));

        //3.2 Excluindo o funcionario por nome usando removeIf
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        //3.3 Imprimindo toda a lista de funcionarios de maneira formatada
        //3.3.1 Primeiramente construir os formatadores para que possa ser impresso da maneira escolhida
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formatador de Data
        NumberFormat decimalFormatado = NumberFormat.getCurrencyInstance(); //Formatador de BigDecimal
        String formato = "%s, %s, %s, %s"; //Formato a ser impresso para que o parametro do sout não fique grande

        //3.3.2 Agora imprimindo toda a lista de Funcionarios
        for(Funcionario funcionario : funcionarios){
            String data = dataFormatada.format(funcionario.getData_de_nascimento());
            String salario = decimalFormatado.format(funcionario.getSalario());
            String impressao = String.format(formato, funcionario.getNome(), data, salario, funcionario.getFuncao());
            System.out.println(impressao);
        }
        System.out.println();

        //3.4 Adicionando aumento de 10% no salário
        for (int i = 0; i < funcionarios.size(); i++) {
            funcionarios.get(i).setSalario(funcionarios.get(i).getSalario().multiply(new BigDecimal(1.1)));
        }

        //3.5 Agrupando os funcionarios por função usando MAP e collectors
        Map<String, List<Funcionario>> funcoes = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        
        //3.6 Imprimindo os funcionarios por função
        for(Map.Entry<String, List<Funcionario> > grupofuncionarios : funcoes.entrySet()) { //Acessando cada grupo de funcionarios pela função
            String funcaoAtual = grupofuncionarios.getKey(); //Recuperando a função da lista dos funcionarios
            List<Funcionario> funcionariosNaFuncao = grupofuncionarios.getValue(); //Recuperando a lista dos funcionarios em si
            
            System.out.println(funcaoAtual); // Imprimindo a função atual para melhor leitura
            for(Funcionario funcionario : funcionariosNaFuncao){//Utilizando o mesmo for usado para imprimir todos os funcionarios
                String data = dataFormatada.format(funcionario.getData_de_nascimento());
                String salario = decimalFormatado.format(funcionario.getSalario());
                String impressao = String.format(formato, funcionario.getNome(), data, salario, funcionario.getFuncao());
                System.out.println(impressao);
            }
            System.out.println();
        }

        //3.8 Imprimindo os funcionarios pela data de nascimento
        //Mes 10
        Month october = Month.of(10);

        //Criando a lista de funcionarios que fazem aniversario no mes 10
        List<Funcionario> mes10 = funcionarios.stream()
            .filter(funcionario -> funcionario
            .getData_de_nascimento()
            .getMonth().equals(october)).collect(Collectors.toList());
        
        //Imprimindo a Lista
        System.out.println(october.getValue());
        for(Funcionario funcionario : mes10){//Utilizando o mesmo for usado para imprimir todos os funcionarios
            String data = dataFormatada.format(funcionario.getData_de_nascimento());
            String salario = decimalFormatado.format(funcionario.getSalario());
            String impressao = String.format(formato, funcionario.getNome(), data, salario, funcionario.getFuncao());
            System.out.println(impressao);
        }
        //Mes 12
        Month december = Month.of(12);

        //Criando a lista de funcionarios que fazem aniversario no mes 12
        List<Funcionario> mes12 = funcionarios.stream()
            .filter(funcionario -> funcionario
            .getData_de_nascimento()
            .getMonth().equals(december)).collect(Collectors.toList());
        
        //Imprimindo a Lista
        System.out.println(december.getValue());
        for(Funcionario funcionario : mes12){//Utilizando o mesmo for usado para imprimir todos os funcionarios
            String data = dataFormatada.format(funcionario.getData_de_nascimento());
            String salario = decimalFormatado.format(funcionario.getSalario());
            String impressao = String.format(formato, funcionario.getNome(), data, salario, funcionario.getFuncao());
            System.out.println(impressao);
        }
        System.out.println();

        //3.9 Imprimindo o funcionario mais velho
        List<Funcionario> funcionariosPorNascimento = funcionarios.stream(). //Primeiramente, fazer uma nova lista 
            sorted(Comparator.comparing(Funcionario::getData_de_nascimento))//ordenando todos pela ordem de nascimento
            .collect(Collectors.toList());

        //Imprimindo o mais velho
        System.out.println("Mais velho");
            String data = dataFormatada.format(funcionariosPorNascimento.get(0).getData_de_nascimento());
            String salario = decimalFormatado.format(funcionariosPorNascimento.get(0).getSalario());
            String impressao = String.format(formato, funcionariosPorNascimento.get(0)
                                                    .getNome(), data, salario, funcionariosPorNascimento
                                                    .get(0).getFuncao());
            System.out.println(impressao);
        System.out.println();

        //3.10 Imprimindo por ordem Alfabetica
        List<Funcionario> funcionariosPorNome = funcionarios.stream(). //Primeiramente, fazer uma nova lista 
            sorted(Comparator.comparing(Funcionario::getNome))//ordenando todos pela ordem de nascimento
            .collect(Collectors.toList());
        System.out.println("Ordenados Por Nome");
        for (Funcionario funcionario : funcionariosPorNome){//utilizando a parte do codigo que imprime toda a lista de funcionarios
            data = dataFormatada.format(funcionario.getData_de_nascimento());
            salario = decimalFormatado.format(funcionario.getSalario());
            impressao = String.format(formato, funcionario.getNome(), data, salario, funcionario.getFuncao());
            System.out.println(impressao);
        }
        System.out.println();

        //3.11 Imprimindo o total dos salários
        BigDecimal valorSalarios = new BigDecimal(0);
        for(Funcionario funcionario : funcionarios){
            valorSalarios = valorSalarios.add(funcionario.getSalario());
        }
        System.out.println("Total dos Salários: " + decimalFormatado.format(valorSalarios));
        System.out.println();

        //3.12 Imprimir a quantidade de salários minimos cada pessoa ganha 
        BigDecimal salarioMinimo = new BigDecimal(1212);
        for(Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getNome() + ": " + funcionario.getSalario()
                                                            .divide(salarioMinimo,2, RoundingMode.HALF_UP)
                                                            .setScale(2, RoundingMode.HALF_UP)
                                                            + " salários");
        }


    }
}
