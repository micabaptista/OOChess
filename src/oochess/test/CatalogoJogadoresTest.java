package oochess.test;

import oochess.app.CatalogoJogadores;
import oochess.app.jogador.Jogador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CatalogoJogadoresTest {
    private CatalogoJogadores catalogoJogadores;

    @Before
    public void setUp() {
        catalogoJogadores = CatalogoJogadores.getInstance();
        Jogador jogador = new Jogador("mike", "mike123", "mikeGamer");
        catalogoJogadores.putJogador(jogador);

    }

    @Test
    public void getJogador() {
        Jogador jogador1 = catalogoJogadores.getJogador("mike");

        Jogador jogadorExpected = new Jogador("mike", "mike123", "mikeGamer");

        Assert.assertEquals(jogador1, jogadorExpected);
    }

    @Test
    public void putJogador() {
        Jogador jogador1 = new Jogador("mike", "mike123", "mikeGamer");

        catalogoJogadores.putJogador(jogador1);

        Assert.assertEquals(jogador1, catalogoJogadores.getJogador("mike"));
    }

    @Test
    public void existsJogador() {
        Jogador jogador1 = new Jogador("mike", "mike123", "mikeGamer");

        catalogoJogadores.putJogador(jogador1);

        Assert.assertTrue(catalogoJogadores.existsJogador("mike"));
    }

}
