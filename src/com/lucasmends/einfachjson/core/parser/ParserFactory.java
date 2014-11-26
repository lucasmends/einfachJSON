/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.core.parser;

import com.lucasmends.einfachjson.core.parser.concrete.*;


/**
 * Creates the parser
 * @author lucas
 */
public class ParserFactory {
    
    /**
     * Creates the parser for the Object to JSON
     * @return the parser
     */
    public static AbstractParser createParser(){
        AbstractParser parser = new StringLikeParser();
        parser.setNextParser( new PrimitiveParser() );
        return parser;
    }
}
