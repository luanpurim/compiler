package actions;

import core.AnalyseResult;
import core.Analyser;
import org.junit.Assert;
import org.junit.Test;

public class ActionsTest {

    @Test
    public void testAction001() {
        String code = CodeTestLoader.loadCode("001");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("001_assert"), result.getCode());
    }

    @Test
    public void testAction002() {
        String code = CodeTestLoader.loadCode("002");
        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals(CodeTestLoader.loadCode("002_assert"), result.getCode());
    }

}
