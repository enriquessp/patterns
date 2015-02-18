package br.com.estudo.patterns.composite;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class TrechoCompostoTest {

    public  List<TrechoAereo> trechosDiretos;
    private TrechoDireto      trechoDiretoUm;
    private TrechoDireto trechoDiretoDois;

    @Before
    public void prepare() {
	LocalDateTime agora = LocalDateTime.now();
	trechoDiretoUm = new TrechoDireto("SAO", "ROM", agora.plus(10, ChronoUnit.DAYS), agora.plus(30, ChronoUnit.DAYS), BigDecimal.TEN);
	trechoDiretoDois = new TrechoDireto("ROM", "CDG", agora.plus(10, ChronoUnit.DAYS), agora.plus(30, ChronoUnit.DAYS), BigDecimal.TEN);
        trechosDiretos = Arrays.asList(trechoDiretoUm, trechoDiretoDois);
    }

    @Test public void testOrigem() throws Exception {
        TrechoComposto trechoComposto = criaTrechoComposto();

        assertEquals("Origem do composto deve ser a origem do primeiro trecho!", trechoDiretoUm.origem(), trechoComposto.origem());
    }


    @Test public void testDestino() throws Exception {
        TrechoComposto trechoComposto = criaTrechoComposto();

        assertEquals("Destino do composto deve ser o destino do ultimo trecho!", trechoDiretoDois.destino(), trechoComposto.destino());

    }

    @Test public void testDataOrigem() throws Exception {
        TrechoComposto trechoComposto = criaTrechoComposto();

        assertEquals("Data Origem do composto deve ser a data origem do primeiro trecho!", trechoDiretoUm.dataOrigem(), trechoComposto.dataOrigem());

    }

    @Test public void testDataDestino() throws Exception {
        TrechoComposto trechoComposto = criaTrechoComposto();

        assertEquals("Data destino do composto deve ser a data destino do ultimo trecho!", trechoDiretoDois.dataDestino(), trechoComposto.dataDestino());

    }

    @Test public void testQtdeConexoes() throws Exception {
        TrechoComposto trechoComposto = criaTrechoComposto();

        assertEquals("Numero de conexoes deveria ser o total de trechos!", trechosDiretos.size(), trechoComposto.qtdeConexoes());

    }

    @Test public void testPreco() throws Exception {
        TrechoComposto trechoComposto = criaTrechoComposto();

        BigDecimal precoEsperado = BigDecimal.ZERO;
        for (TrechoAereo trechoAereo : trechosDiretos) {
            precoEsperado = precoEsperado.add(trechoAereo.preco());
        }

        assertEquals("Valor deveria ser a soma de todos os trechos!!", precoEsperado, trechoComposto.preco());

    }

    private TrechoComposto criaTrechoComposto() {
	TrechoComposto trechoComposto = new TrechoComposto();
	trechosDiretos.forEach(trechoComposto::addTrecho);
	return trechoComposto;
    }

}