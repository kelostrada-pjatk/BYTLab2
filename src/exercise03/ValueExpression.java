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
public class ValueExpression implements IExpression {
    
    private final int value;

    public ValueExpression(int value) {
        this.value = value;
    }
    
    @Override
    public int evaluate() {
        return value;
    }
    
    
    
}
