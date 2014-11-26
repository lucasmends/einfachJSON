/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.criteria;

/**
 *
 * @author lucas
 */
public final class WrapperPrimitive implements Criteria{

    private final Class<?> type;
    
    public WrapperPrimitive(Class<?> type){
        this.type = type;
    }
    
    @Override
    public boolean accepts(Class<?> type) {
        return this.type.equals( type );
    }
    
}
