package actions;

import core.AnalyseResult;
import core.Analyser;
import org.junit.Assert;
import org.junit.Test;

public class ActionsTest {

    @Test
    public void testCode001() {
        String code = CodeTestLoader.loadCode("001");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("001_assert"), result.getCode());
    }

    @Test
    public void testCode002() {
        String code = CodeTestLoader.loadCode("002");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("002_assert"), result.getCode());
    }

    @Test
    public void testCode003() {
        String code = CodeTestLoader.loadCode("003");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("003_assert"), result.getCode());
    }

    @Test
    public void testCode004() {
        String code = CodeTestLoader.loadCode("004");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("004_assert"), result.getCode());
    }

    @Test
    public void testCode005() {
        String code = CodeTestLoader.loadCode("005");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("005_assert"), result.getCode());
    }

    @Test
    public void testCode006() {
        String code = CodeTestLoader.loadCode("006");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("006_assert"), result.getCode());
    }

    @Test
    public void testCode007() {
        String code = CodeTestLoader.loadCode("007");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertTrue(result.hasError());
        Assert.assertEquals("Erro na linha 5 - & símbolo inválido", result.getError().getMessage());
    }

    @Test
    public void testCode008() {
        String code = CodeTestLoader.loadCode("008");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertTrue(result.hasError());
        Assert.assertEquals("Erro na linha 3 - Identificador '_x' não declarado", result.getError().getMessage());
    }

    @Test
    public void testCode009() {
        String code = CodeTestLoader.loadCode("009");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertTrue(result.hasError());
        Assert.assertEquals("Erro na linha 2 - Identificador '_x' já declarado", result.getError().getMessage());
    }

    @Test
    public void testCode010() {
        String code = CodeTestLoader.loadCode("010");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertTrue(result.hasError());
        Assert.assertEquals("Erro na linha 4 - Tipo não é um booleano", result.getError().getMessage());
    }

}
