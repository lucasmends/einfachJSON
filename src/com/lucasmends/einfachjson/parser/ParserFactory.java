/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser;

import com.lucasmends.einfachjson.parser.core.AbstractAtributeParser;
import com.lucasmends.einfachjson.parser.core.ParserAtributeFactory;

/**
 *
 * @author lucas
 */
public class ParserFactory {
    public static ParseObjToJSON createParser(){
        AbstractAtributeParser atributeParser = ParserAtributeFactory.createParser();
        ParseObjToJSON parser = new ParserConcrete(atributeParser);

        atributeParser.setParser(parser);
        
        return parser;
    }
}
