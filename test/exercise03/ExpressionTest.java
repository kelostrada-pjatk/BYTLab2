package exercise03;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionTest {

    @Test
    public void testConstant() {
        IExpression e = new ValueExpression(-43);
        assertEquals(e.evaluate(), -43);
    }

    @Test
    public void testAddition() {
        IExpression e = new AddExpression(new ValueExpression(100),
                new ValueExpression(-100));
        assertEquals(e.evaluate(), 0);
    }

    @Test
    public void testSubtraction() {
        IExpression e = new SubExpression(new ValueExpression(100),
                new ValueExpression(-100));
        assertEquals(e.evaluate(), 200);
    }

    @Test
    public void testMultiplication() {
        IExpression e = new MulExpression(new ValueExpression(100),
                new ValueExpression(-100));
        assertEquals(e.evaluate(), -10000);
    }

    @Test
    public void testDivision() {
        IExpression e = new DivExpression(new ValueExpression(100), new ValueExpression(
                -100));
        assertEquals(e.evaluate(), -1);
    }

    @Test
    public void testComplexExpression() {
        // 1+2-3*4/5
        IExpression e = new SubExpression(new AddExpression(
                new ValueExpression(1), new ValueExpression(2)), new DivExpression(
                        new MulExpression(new ValueExpression(3), new ValueExpression(4)),
                        new ValueExpression(5)));
        assertEquals(e.evaluate(), 1);
    }

}
