package br.com.estudo.patterns.strategy.calculo;

import br.com.estudo.patterns.strategy.Veiculo;

import java.time.Duration;

public class CalculaDiaria implements CalculaValor {

    private final double valorDiaria;

    public CalculaDiaria(double valorDiaria) {
	this.valorDiaria = valorDiaria;
    }

    @Override public double calcular(Duration periodo, Veiculo veiculo) {
	return valorDiaria * (periodo.toDays() == 0 ? 1 :  periodo.toDays()) ;
    }
}