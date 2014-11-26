package com.lucasmends.einfachjson.core.parser;


import com.lucasmends.einfachjson.criteria.Criteria;
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
 *  Chain of Rsponsability for parseing the attributes
 * 
 * @author Lucas
 */
public abstract class AbstractParser {
    
    protected Criteria accepetdType;
    private AbstractParser nextParser;
    
    
    public AbstractParser(){
        nextParser = null;
    }
    
    /**
     * Setting the next Parser for the chain
     * @param nextParser the next parser
     */
    public void setNextParser(AbstractParser nextParser){
        this.nextParser = nextParser;
    }
    
    /**
     * Get the atribute and its value as a JSON notation
     * @param atribute the atribute
     * @param obj the object for the parser
     * @return the JSON notation like "atribute" : value
     */
    public String fieldToString(Field atribute, Object obj){
        if(accepetdType.accepts(atribute.getType()))
            try {
                return getNotationJSON(atribute, obj);
        } catch (IllegalAccessException ex) {
                System.err.println("Error accessing an atribute");
                System.err.println(ex.getMessage());
        }
        if(nextParser != null)
            return nextParser.fieldToString(atribute, obj);
        return new String();
    }
    
    protected abstract String getNotationJSON(Field attribute, Object obj) throws IllegalAccessException;
}
