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
public abstract class OperatorExpression implements IExpression {
    
    public OperatorExpression(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    protected IExpression left;
    protected IExpression right;
    
}
