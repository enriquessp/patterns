package br.com.estudo.patterns.strategy;

import br.com.estudo.patterns.strategy.calculo.CalculaValor;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.Duration.*;

public class ContaEstacioanmento {

    private CalculaValor calculo;

    private Veiculo       veiculo;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public double valorConta() {
	return calculo.calcular(between(inicio, fim), veiculo);
    }

    public void setCalculo(CalculaValor calculo) {
	this.calculo = calculo;
    }

    public void setInicio(LocalDateTime inicio) {
	this.inicio = inicio;
    }

    public void setFim(LocalDateTime fim) {
	this.fim = fim;
    }

    public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
    }
}