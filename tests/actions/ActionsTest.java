package actions;

import core.AnalyseResult;
import core.Analyser;
import org.junit.Assert;
import org.junit.Test;

public class ActionsTest {

    @Test
    public void testAction001() {
        String code = new StringBuilder()
                .append("number: _a, _b { write(_a + _b) }")
                .toString();

        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        System.out.println(result.getCode());
        Assert.assertEquals("", result.getCode());
    }

}
