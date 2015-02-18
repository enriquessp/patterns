package br.com.estudo.patterns.composite;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TrechoComposto implements TrechoAereo {

    private final List<TrechoAereo> trechos;

    public TrechoComposto() {
        this.trechos = new LinkedList<>();
    }

    public void addTrecho(TrechoAereo trecho) {
        trechos.add(trecho);
    }

    @Override public String origem() {
	return trechos.stream().findFirst().get().origem();
    }

    @Override public String destino() {
	return trechos.get(trechos.size()-1).destino();
    }

    @Override public LocalDateTime dataOrigem() {
	return trechos.stream().findFirst().get().dataOrigem();
    }

    @Override public LocalDateTime dataDestino() {
	return trechos.get(trechos.size()-1).dataDestino();
    }

    @Override public int qtdeConexoes() {
	return trechos.size();
    }

    @Override public BigDecimal preco() {
        BigDecimal preco = BigDecimal.ZERO;
        for (TrechoAereo trecho : trechos) {
            preco = preco.add(trecho.preco());
        }
	return preco;
    }
}
