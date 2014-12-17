/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core.iterable;

import com.lucasmends.einfachjson.parser.core.IterableAtributeParser;
import com.lucasmends.einfachjson.criteria.Criteria;
import com.lucasmends.einfachjson.parser.ParseObjToJSON;
import com.lucasmends.einfachjson.parser.core.concrete.ObjectAtributeParser;

/**
 *
 * @author lucas
 */
public abstract class IterableChain extends IterableAtributeParser {

    protected IterableChain nextIterable;
    protected Criteria criteria;

    
    @Override
    public String value(Object o) {
        if (this.criteria.accepts(o.getClass())) {
            return getNotation(o);
        }
        return nextIterable.value(o);

    }

    @Override
    public void setParser(ParseObjToJSON parser){
        if(this instanceof ObjectIterable){
            this.setParserInternal(parser);
        } else if(this.nextIterable != null){
            this.nextIterable.setParser(parser);
        }
        if(this.getNextParser() != null)
            this.getNextParser().setParser(parser);
    }
    
   
    /**
     * For the chain class do the appropriate notation.
     * @param o the object notation
     * @return 
     */
    protected abstract String getNotation(Object o);
}
