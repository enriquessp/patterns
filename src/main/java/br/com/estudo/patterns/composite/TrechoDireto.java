package br.com.estudo.patterns.composite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TrechoDireto implements TrechoAereo {

    private final String origem;
    private final String destino;
    private final LocalDateTime dataOrigem;
    private final LocalDateTime dataDestino;
    private final BigDecimal preco;

    public TrechoDireto(String origem, String destino, LocalDateTime dataOrigem, LocalDateTime dataDestino, BigDecimal preco) {
        this.origem = origem;
        this.destino = destino;
        this.dataOrigem = dataOrigem;
        this.dataDestino = dataDestino;
        this.preco = preco;
    }

    @Override public String origem() {
	return origem;
    }

    @Override public String destino() {
	return destino;
    }

    @Override public LocalDateTime dataOrigem() {
	return dataOrigem;
    }

    @Override public LocalDateTime dataDestino() {
	return dataDestino;
    }

    @Override public int qtdeConexoes() {
	return 0;
    }

    @Override public BigDecimal preco() {
	return preco;
    }
}