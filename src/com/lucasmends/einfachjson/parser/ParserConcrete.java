/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser;

import com.lucasmends.einfachjson.parser.core.AbstractAtributeParser;
import java.lang.reflect.Field;

/**
 *
 * @author lucas
 */
public class ParserConcrete implements ParseObjToJSON {

    AbstractAtributeParser atributeParser;

    
    /**
     * Implementation of the JSON parser.
     * @param atributeParser A concrete AbstractAtributeParser, an object that 
     *                      transforms a field into a JSON notation
     */
    public ParserConcrete(AbstractAtributeParser atributeParser) {
        this.atributeParser = atributeParser;
    }

    @Override
    public String objToJSON(Object o) {

        Field[] atributes = o.getClass().getDeclaredFields();
        if (atributes.length > 1) {
            StringBuilder json = new StringBuilder("{ ");

            for (Field atribute : atributes) {
                json.append(atributeParser.fieldToString(atribute, o));
                json.append(", ");
            }

            //Removing the ", "
            json.deleteCharAt(json.length() - 1);
            json.deleteCharAt(json.length() - 1);
            return json.append("}").toString();
        }
        return new String();
    }

}
