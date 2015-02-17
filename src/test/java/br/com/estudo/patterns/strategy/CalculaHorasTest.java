package br.com.estudo.patterns.strategy;

import br.com.estudo.patterns.strategy.calculo.CalculaHoras;
import org.junit.Test;
import org.mockito.Mock;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class CalculaHorasTest {

    @Mock private Veiculo veiculoMock;

    @Test public void testCalcular() throws Exception {
        LocalDateTime quatroHoras = LocalDateTime.now().minus(4, ChronoUnit.HOURS);
        LocalDateTime noveHoras = LocalDateTime.now().minus(9, ChronoUnit.HOURS);
        LocalDateTime dezHoras = LocalDateTime.now().minus(10, ChronoUnit.HOURS);
        LocalDateTime onzeHoras = LocalDateTime.now().minus(11, ChronoUnit.HOURS);
        LocalDateTime dozeHoras = LocalDateTime.now().minus(12, ChronoUnit.HOURS);
        LocalDateTime trezeHoras = LocalDateTime.now().minus(13, ChronoUnit.HOURS);

        LocalDateTime now = LocalDateTime.now();

        CalculaHoras calculo = new CalculaHoras();

        assertEquals("A cada nove horas 10", Double.valueOf(15), Double.valueOf(calculo.calcular(Duration.between(quatroHoras, now), veiculoMock)));
        assertEquals("A cada nove horas 10", Double.valueOf(15), Double.valueOf(calculo.calcular(Duration.between(noveHoras, now), veiculoMock)) );
        assertEquals("(10) Apos nove horas, cada hora 2", Double.valueOf(17), Double.valueOf(calculo.calcular(Duration.between(dezHoras, now), veiculoMock)));
        assertEquals("(11) Apos nove horas, cada hora 2", Double.valueOf(19), Double.valueOf(calculo.calcular(Duration.between(onzeHoras, now), veiculoMock)));
        assertEquals("(12) Apos nove horas, cada hora 2", Double.valueOf(21), Double.valueOf(calculo.calcular(Duration.between(dozeHoras, now), veiculoMock)));
        assertEquals("(13) Apos nove horas, cada hora 2", Double.valueOf(23), Double.valueOf(calculo.calcular(Duration.between(trezeHoras, now), veiculoMock)));
    }
}