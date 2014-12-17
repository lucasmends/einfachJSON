/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson;

import com.lucasmends.einfachjson.parser.ParserFactory;

/**
 *
 * @author lucas
 */
public class JSONBuilder {
    
    
    public static JSONObject createJSONObject(){
        return new JSONObjectConcrete(ParserFactory.createParser());
    }
}
