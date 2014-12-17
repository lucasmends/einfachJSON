/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.criteria.concrete;

import com.lucasmends.einfachjson.criteria.Criteria;

/**
 * 
 * @author lucas
 */
public class ExtendCriteria implements Criteria {

    private final Class<?> type;
    
    public ExtendCriteria(Class<?> type){
        this.type = type;
    }
    
    @Override
    public boolean accepts(Class<?> type) {
        return type.getSuperclass().equals(this.type) || type.equals(this.type);
    }
    
}
