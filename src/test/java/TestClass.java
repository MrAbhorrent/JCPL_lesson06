import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestClass {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3, 1, 4, 4, 2, 3, 1}, new int[]{2, 3, 1}},
                {new int[]{4, 3, 4, 5, 6, 4, 3, 2}, new int[]{3, 2}}
        });
    }

    private int[] in;
    private int[] out;

    public TestClass(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private MainClass mainClass;

    @Before
    public void startTest() {
        mainClass = new MainClass();
    }

    @Test
    public void testLast4() {
        Assert.assertArrayEquals(out, mainClass.concat4array(in));
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        mainClass.concat4array(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
    }
}