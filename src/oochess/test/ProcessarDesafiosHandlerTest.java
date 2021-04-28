package oochess.test;

import oochess.app.modelo.desafio.Desafio;
import oochess.app.modelo.desafio.DesafioBuilder;
import oochess.app.facade.dto.DesafioDTO;
import oochess.app.facade.handlers.ProcessarDesafiosHandler;
import oochess.app.modelo.jogador.Jogador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class ProcessarDesafiosHandlerTest {

    private static final LocalDateTime DATE_TIME = LocalDateTime.now();
    private ProcessarDesafiosHandler processarDesafiosHandler;
    private Jogador jogador1;


    @Before
    public void setUp() {
        jogador1 = new Jogador("Mike", "mike123", "mikeGamer");
        jogador1.adicionaDesafioRecebido(new DesafioBuilder()
                .withDataPartida(DATE_TIME)
                .withMensagem("Boa sorte")
                .build());

        processarDesafiosHandler = new ProcessarDesafiosHandler(jogador1);
    }


    @Test
    public void consultarDesafiosTest() {
         List<DesafioDTO> desafiosPendentes = processarDesafiosHandler.consultarDesafiosPendentes();

        Desafio expected = new DesafioBuilder()
                .withDataPartida(DATE_TIME)
                .withMensagem("Boa sorte")
                .build();

        Assert.assertEquals(desafiosPendentes.get(0).getCodigo(), expected.getCodigo());
        Assert.assertEquals(desafiosPendentes.get(0).getDataPartida(), expected.getDataPartida());
        Assert.assertEquals(desafiosPendentes.get(0).getMensagem(), expected.getMensagem());
    }

    @Test
    public void respondeADesafioWithYes() {
        processarDesafiosHandler.respondeADesafio("1", true);
        Assert.assertTrue(jogador1.getDesafio("1").getResposta());
    }

    @Test
    public void respondeADesafioWithNo() {
        processarDesafiosHandler.respondeADesafio("1", false);
        Assert.assertFalse(jogador1.getDesafio("1").getResposta());
    }

    @Test
    public void indicaNovaDataTest() {
        LocalDateTime newDate = LocalDateTime.now();

        processarDesafiosHandler.respondeADesafio("1", false);
        processarDesafiosHandler.indicaNovaData(newDate);

        Assert.assertEquals(jogador1.getDesafio("1").getDataPartida(), newDate);
    }



}
