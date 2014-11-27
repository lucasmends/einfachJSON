/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core.concrete;

import com.lucasmends.einfachjson.criteria.CriteriaBuilder;
import com.lucasmends.einfachjson.parser.core.TemplateAtributeParser;

/**
 *
 * @author lucas
 */
public class MapAtributeParser extends TemplateAtributeParser{

    public MapAtributeParser(){
        super();
        this.accepetdType = CriteriaBuilder.mapType();
    }
    
    @Override
    protected String value(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
