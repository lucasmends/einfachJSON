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
class PrimitiveIterable extends IterableChain{

    public PrimitiveIterable(){
        this.criteria = CriteriaBuilder.primitiveCriteria();
        this.nextIterable = new StringLikeIterable();
    }
    
    @Override
    protected String getNotation(Object o) {
        return o.toString();
    }


    
}
