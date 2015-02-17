package br.com.estudo.patterns.strategy;

import br.com.estudo.patterns.strategy.calculo.CalculaDiaria;
import br.com.estudo.patterns.strategy.calculo.CalculaHoras;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MainStrategyService {

    public static void main(String[] args) {
        double valor_diaria = 10;
        ContaEstacioanmento conta = new ContaEstacioanmento();
        conta.setInicio(LocalDateTime.now().minus(2, ChronoUnit.DAYS));
        conta.setFim(LocalDateTime.now());
        conta.setCalculo(new CalculaDiaria(valor_diaria));

        System.out.println("Valor da diaria em periodo de 2 dias.");
        System.out.println("Valor: " + conta.valorConta());

        System.out.println("Mudando a conta para que seja por periodos de 9 e demais horas 2");

        conta.setCalculo(new CalculaHoras());
        System.out.println("Valor do periodo com as mesmas 24 horas.");
        System.out.println("Valor: " + conta.valorConta());

    }

}