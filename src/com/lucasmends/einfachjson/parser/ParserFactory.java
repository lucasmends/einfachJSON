/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser;

/**
 *
 * @author lucas
 */
public class ParserFactory {
    public ParseObjToJSON createParser(){
        ParseObjToJSON parser = new ParserConcrete();
        /**
         * Reflection to set the parser in ObjectIterable and ObjectAtributeParser
         */
        
        return parser;
    }
}
