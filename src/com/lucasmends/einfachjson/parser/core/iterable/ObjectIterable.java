/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core.iterable;

import com.lucasmends.einfachjson.parser.ParseObjToJSON;
import com.lucasmends.einfachjson.criteria.Criteria;
import com.lucasmends.einfachjson.parser.NullParser;

/**
 *
 * @author lucas
 */
class ObjectIterable extends IterableChain{

    private ParseObjToJSON parser;
    
    
    /**
     * Must be accessed by reflection.
     * @param parser 
     */
    public void setParser(ParseObjToJSON parser){
        this.parser = parser;
    }
    
    public ObjectIterable(){
        this.criteria = new Criteria() {

            @Override
            public boolean accepts(Class<?> type) {
                return true;
            }
        };
        this.parser = new NullParser();
    }
    
    @Override
    protected String getNotation(Object o) {
        return parser.objToJSON(o);
    }
    
}
