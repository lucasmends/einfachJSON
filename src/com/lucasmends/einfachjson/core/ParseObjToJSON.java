/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.core;

/**
 *
 * @author lucas
 */
public interface ParseObjToJSON {
    /**
     * Transform the object into a JSON notation.
     * @param o the object to be transformed
     * @return the String notation
     */
    public String objToJSON( Object o );
}
