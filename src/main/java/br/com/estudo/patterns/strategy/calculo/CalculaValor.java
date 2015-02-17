package br.com.estudo.patterns.strategy.calculo;

import br.com.estudo.patterns.strategy.Veiculo;

import java.time.Duration;

public interface CalculaValor {
    public double calcular(Duration periodo, Veiculo veiculo);
}