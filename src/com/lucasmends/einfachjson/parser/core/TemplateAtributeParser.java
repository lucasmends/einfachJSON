package com.lucasmends.einfachjson.parser.core;


import java.lang.reflect.Field;

/*
 * Copyright 2014 Lucas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Using the template method
 * @author Lucas
 */
public abstract class TemplateAtributeParser extends AbstractAtributeParser{
    

    @Override
    protected String getNotationJSON(Field attribute, Object obj) throws IllegalAccessException{
        StringBuilder notation = new StringBuilder();
        notation.append("\"").append(attribute.getName()).append("\": ");
        
        //Checking the attribute's accessibility
        if(!attribute.isAccessible())
            attribute.setAccessible(true);
        
        notation.append(value(attribute.get(obj)));
        
        return notation.toString();
    }
    
    
    
    /**
     * Return the value depending by the implementation
     * @param value
     * @return the value in String
     */
    protected abstract String value(Object value);
}
