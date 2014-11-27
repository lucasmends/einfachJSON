/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.parser.core;

import com.lucasmends.einfachjson.criteria.CriteriaBuilder;
import java.lang.reflect.Field;

/**
 * Template method class for iterable types.
 *
 * @author lucasjson
 */
public abstract class IterableAtributeParser extends AbstractAtributeParser {

    public IterableAtributeParser(){
        this.accepetdType = CriteriaBuilder.iterableType();
    }
    
    @Override
    protected String getNotationJSON(Field attribute, Object obj) throws IllegalAccessException {
        StringBuilder notation = new StringBuilder();
        notation.append("\"").append(attribute.getName()).append("\": { ");

        //Checking the attribute's accessibility
        if (!attribute.isAccessible()) {
            attribute.setAccessible(true);
        }
        for (Object o : (Iterable) attribute.get(obj)) {
            notation.append(value(o)).append(", ");
        }

        //Removing the ", "
        notation.deleteCharAt(notation.length() - 1);
        notation.deleteCharAt(notation.length() - 1);
        return notation.append("}").toString();
    }

    /**
     * Return the value depending by the implementation
     *
     * @param value
     * @return the value in String
     */
    protected abstract String value(Object value);
}
