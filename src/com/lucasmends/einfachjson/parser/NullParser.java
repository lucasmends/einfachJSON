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
public class NullParser implements ParseObjToJSON{

   
    public NullParser(){
        
    }
    
    
    @Override
    public String objToJSON(Object o) {
        throw new UnsupportedOperationException("Parser not implemented"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
