package br.com.estudo.patterns.strategy.calculo;

import br.com.estudo.patterns.strategy.Veiculo;

import java.time.Duration;

public class CalculaHoras implements CalculaValor {

    @Override public double calcular(Duration periodo, Veiculo veiculo) {
        // Pode-se incluir valor específico por tipo de veículo
        if (periodo.toHours() <= Periodo.INICIAL.horas) {
            return Periodo.INICIAL.valor;
        } else {
            long horasExcedentes = periodo.toHours() - Periodo.INICIAL.horas;
            return Periodo.INICIAL.valor + horasExcedentes * Periodo.DEMAIS.valor;
        }
    }

    enum Periodo { INICIAL(9, 15), DEMAIS(1, 2);

        private final int horas;
        private final double valor;

        Periodo(int horas, double valor) {
            this.horas = horas;
            this.valor = valor;
        }
    }
}