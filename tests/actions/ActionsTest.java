package actions;

import core.AnalyseResult;
import core.Analyser;
import org.junit.Assert;
import org.junit.Test;

public class ActionsTest {

    @Test
    public void testAction001() {
        String code = new StringBuilder()
                .append("number: a b { write(a + b) }")
                .toString();

        AnalyseResult result = new Analyser().analyse(code);
        Assert.assertFalse(result.hasError());
        Assert.assertEquals("", result.getCode());
    }

}
