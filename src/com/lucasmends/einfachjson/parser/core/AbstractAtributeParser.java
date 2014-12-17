package com.lucasmends.einfachjson.parser.core;

import com.lucasmends.einfachjson.criteria.Criteria;
import com.lucasmends.einfachjson.parser.ParseObjToJSON;
import com.lucasmends.einfachjson.annotations.Ignore;
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
 * Chain of Rsponsability for parseing the attributes
 *
 * @author Lucas
 */
public abstract class AbstractAtributeParser {

    protected Criteria accepetdType;
    private AbstractAtributeParser nextParser;

    public AbstractAtributeParser() {
        nextParser = null;
    }

    /**
     * Setting the next Parser for the chain
     *
     * @param nextParser the next parser
     */
    public void setNextParser(AbstractAtributeParser nextParser) {
        this.nextParser = nextParser;
    }

    /**
     * Get the atribute and its value as a JSON notation, if the Ignore Annotation
     * is present, this ignore the atribute.
     *
     * @param atribute the atribute
     * @param obj the object for the parser
     * @return the JSON notation like "atribute" : value
     */
    public String fieldToString(Field atribute, Object obj) {
        if (atribute.isAnnotationPresent(Ignore.class)) {
            return new String();
        }
        if (accepetdType.accepts(atribute.getType())) {
            try {
                return getNotationJSON(atribute, obj);
            } catch (IllegalAccessException ex) {
                System.err.println("Error accessing an atribute");
                System.err.println(ex.getMessage());
            }
        }
        if (nextParser != null) {
            return nextParser.fieldToString(atribute, obj);
        }
        return new String();
    }

    /**
     * Method for the concrete classes implements how to do the JSON notation.
     * @param attribute the atribute
     * @param obj the object for the parser
     * @return the JSON notation like "atribute" : value
     * @throws IllegalAccessException Reflection Excepetion for Illegal Access
     */
    protected abstract String getNotationJSON(Field attribute, Object obj) throws IllegalAccessException;

    /**
     * My solution for putting a Parser for the Objects Parsers, like it uses recursion.
     * @param parser the parser
     */
    public abstract void setParser(ParseObjToJSON parser);

    /**
     * Only the classes that will use the parser Overrides this.
     * @param parser the parser
     */
    protected void setParserInternal(ParseObjToJSON parser) {
    }

    protected AbstractAtributeParser getNextParser() {
        return nextParser;
    }
}
