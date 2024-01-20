package algorithms.intparser;

import org.junit.Assert;
import org.junit.Test;

public class IntParserTest {

    @Test
    public void testParseInt() {
        String testStr = "1239";
        int result = IntParser.parseInt(testStr);
        Assert.assertEquals("wrong int", 1239, result);
    }

}
