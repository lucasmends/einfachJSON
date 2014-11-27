/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core;

import com.lucasmends.einfachjson.parser.core.concrete.*;
import com.lucasmends.einfachjson.parser.core.iterable.IterableChainFactory;


/**
 * Creates the parser
 * @author lucas
 */
public class ParserAtributeFactory {
    
    /**
     * Creates the parser for the Object to JSON
     * @return the parser
     */
    public static AbstractAtributeParser createParser(){
        AbstractAtributeParser parser = new StringLikeAtributeParser();
        AbstractAtributeParser primitive = new PrimitiveAtributeParser();
        AbstractAtributeParser iterable = IterableChainFactory.getChain();
        AbstractAtributeParser map = new MapAtributeParser();
        AbstractAtributeParser objectParser = new ObjectAtributeParser();
        
        iterable.setNextParser(objectParser);
        primitive.setNextParser(iterable);
        parser.setNextParser(primitive);
        
        return parser;
    }
}
