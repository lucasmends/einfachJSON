/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core.iterable;

import com.lucasmends.einfachjson.criteria.CriteriaBuilder;

/**
 *
 * @author lucas
 */
class MapIterable extends IterableChain{
    
    public MapIterable(){
        this.criteria = CriteriaBuilder.mapType();
        this.nextIterable = new ObjectIterable();
    }
    
    @Override
    protected String getNotation(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
