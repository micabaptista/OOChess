package oochess.test;

import oochess.app.OOChess;
import oochess.app.facade.handlers.RegistarUtilizadorHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistarUtilizadorTest {
    private RegistarUtilizadorHandler regHandler;


    @Before
    public void setUp() {

        OOChess p = new OOChess();
        regHandler = p.getRegistarUtilizadorHandler();
    }


    @Test
    public void isJogadorRegistadoAddToMap() {
        regHandler.registarUtilizador("Felismina1", "hortadafcul1", "fel1sgamer1");

        Assert.assertTrue(regHandler.isJogadorRegistado("Felismina1"));
    }

    @Test
    public void isJogadorRegistadoAddToMap2() {
        regHandler.registarUtilizador("Felismina2", "hortadafcul2", "fel1sgamer2");
        regHandler.registarUtilizador("Silvino2", "bardoc2", "s1lv1n02");

        Assert.assertTrue(regHandler.isJogadorRegistado("Felismina2"));
        Assert.assertTrue(regHandler.isJogadorRegistado("Silvino2"));
    }

    @Test
    public void isJogadorRegistadoAddToMap3() {
        regHandler.registarUtilizador("Felismina3", "hortadafcul3", "fel1sgamer3");
        regHandler.registarUtilizador("Silvino3", "bardoc3", "s1lv1n03");
        regHandler.registarUtilizador("Maribel3", "torredotombo", "SkubaPatr0l");

        Assert.assertTrue(regHandler.isJogadorRegistado("Felismina3"));
        Assert.assertTrue(regHandler.isJogadorRegistado("Silvino3"));
        Assert.assertTrue(regHandler.isJogadorRegistado("Maribel3"));
    }
}
