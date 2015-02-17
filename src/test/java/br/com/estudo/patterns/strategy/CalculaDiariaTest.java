package br.com.estudo.patterns.strategy;

import br.com.estudo.patterns.strategy.calculo.CalculaDiaria;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class CalculaDiariaTest {

    private static final double VALOR_DIARIA = 10;
    @Mock private Veiculo veiculoMock;

    @Before public void prepare() {
	MockitoAnnotations.initMocks(this);
    }

    @Test public void testCalcular()
		    throws Exception {

	LocalDateTime dezHorasAtras = LocalDateTime.now().minus(10, ChronoUnit.HOURS);
	LocalDateTime umDia = LocalDateTime.now().minus(24, ChronoUnit.HOURS);
	LocalDateTime doisDia = LocalDateTime.now().minus(48, ChronoUnit.HOURS);
	LocalDateTime agora = LocalDateTime.now();

        CalculaDiaria calculo = new CalculaDiaria(VALOR_DIARIA);

        assertEquals(Double.valueOf(calculo.calcular(Duration.between(dezHorasAtras, agora), veiculoMock)), Double.valueOf(10));
        assertEquals(Double.valueOf(calculo.calcular(Duration.between(umDia, agora), veiculoMock)), Double.valueOf(10));
        assertEquals(Double.valueOf(calculo.calcular(Duration.between(doisDia, agora), veiculoMock)), Double.valueOf(20));
    }
}