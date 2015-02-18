package br.com.estudo.patterns.composite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TrechoAereo {

    public String origem();
    public String destino();
    public LocalDateTime dataOrigem();
    public LocalDateTime dataDestino();
    public int qtdeConexoes();
    public BigDecimal preco();

}
