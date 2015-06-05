/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise03;

/**
 *
 * @author kelu
 */
public class SubExpression extends OperatorExpression {
    
    public SubExpression(IExpression left, IExpression right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}