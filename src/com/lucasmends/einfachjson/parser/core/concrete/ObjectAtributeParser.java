/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core.concrete;

import com.lucasmends.einfachjson.parser.ParseObjToJSON;
import com.lucasmends.einfachjson.parser.core.TemplateAtributeParser;
import com.lucasmends.einfachjson.criteria.Criteria;
import com.lucasmends.einfachjson.parser.NullParser;

/**
 *
 * @author lucas
 */
public class ObjectAtributeParser extends TemplateAtributeParser{

    private ParseObjToJSON parser;

    public ObjectAtributeParser(){
        super();
        this.accepetdType = new Criteria() {

            @Override
            public boolean accepts(Class<?> type) {
                return true;
            }
        };
        this.parser = new NullParser();
    }
    
    /**
     * Must be accessed by reflection.
     *
     * @param parser
     */
    public void setParser(ParseObjToJSON parser) {
        this.parser = parser;
    }

    @Override
    protected String value(Object value) {
        return parser.objToJSON(value);
    }
    
    
}
