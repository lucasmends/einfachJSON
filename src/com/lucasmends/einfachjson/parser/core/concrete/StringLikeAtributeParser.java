/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core.concrete;

import com.lucasmends.einfachjson.parser.core.TemplateAtributeParser;
import com.lucasmends.einfachjson.criteria.CriteriaBuilder;


/**
 *
 * @author lucas
 */
public class StringLikeAtributeParser extends TemplateAtributeParser{

    public StringLikeAtributeParser(){
        super();
        this.accepetdType = CriteriaBuilder.stringLikeCriteria();
    }
    
    @Override
    protected String value(Object value) {
        return "\"" + value.toString() + "\"";
    }

    
}
