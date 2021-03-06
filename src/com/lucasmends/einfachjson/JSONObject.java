/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson;

import com.lucasmends.einfachjson.parser.ParseObjToJSON;

/**
 * This class can transform an Object into a JSON notation and the opposite too.
 * @author lucas
 */
public abstract class JSONObject {
    
    protected ParseObjToJSON objToJSON;
    
    public JSONObject( ParseObjToJSON parser){
        this.objToJSON = parser;
    }
    
    /**
     * Transform an Object into a JSON notation.
     * @param obj the object to be transformed
     * @return the JSON notation of the Object
     */
    public abstract String objToJSON(Object obj);
}
