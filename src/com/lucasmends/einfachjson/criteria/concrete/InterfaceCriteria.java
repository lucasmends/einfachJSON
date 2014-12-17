/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.criteria.concrete;

import com.lucasmends.einfachjson.criteria.Criteria;

/**
 * Criteria for checking if an interface is implemented by a Class.
 * @author lucas
 */
public final class InterfaceCriteria implements Criteria{

    private final Class<?> type;
    
    public InterfaceCriteria(Class<?> type){
        this.type = type;
    }
    
    @Override
    public boolean accepts(Class<?> type) {
        for(Class<?> intface: type.getInterfaces())
            if(intface.equals(this.type))
                return true;
        return this.type.equals(type);
    }
    
}
