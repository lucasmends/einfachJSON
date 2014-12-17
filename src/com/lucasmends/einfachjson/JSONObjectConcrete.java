/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson;

import com.lucasmends.einfachjson.parser.ParseObjToJSON;

/**
 *
 * @author lucas
 */
class JSONObjectConcrete extends JSONObject{

    public JSONObjectConcrete(ParseObjToJSON parser) {
        super(parser);
    }

    @Override
    public String objToJSON(Object obj) {
        return this.objToJSON.objToJSON(obj);
    }
    
}
