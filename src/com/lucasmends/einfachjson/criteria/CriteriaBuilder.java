/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.criteria;

/**
 *
 * @author lucas
 */
public class CriteriaBuilder {

    /**
     * Creates a criteria that checks if it a Class given is primitive (int,
     * long, boolean, ...), excepts for char and their wrappers (Integer,
     * Double, Boolean, ...)
     *
     * @return the crieteria
     */
    public static Criteria primitiveCriteria() {
        CompositeCriteria primtiveCriteria = new CompositeCriteria();
        
        //the criteria for int, double, boolean, ... execpts for char
        primtiveCriteria.addCriteria(
                new Criteria() {

                    @Override
                    public boolean accepts(Class<?> type) {
                        return type.isPrimitive() && !type.equals(char.class);
                    }
                });

        //check if it is Integer, Double,...
        primtiveCriteria.addCriteria(new Criteria() {

            @Override
            public boolean accepts(Class<?> type) {
                return type.isAssignableFrom(Number.class);
            }
        });
        
        primtiveCriteria.addCriteria(new WrapperPrimitive(Boolean.class));
        
        
        return primtiveCriteria;
    }

    /**
     * Creates a criteria that checks if it is a caracter or string type.
     * @return the criteria
     */
    public static Criteria stringLikeCriteria() {
        CompositeCriteria stringLike = new CompositeCriteria();

        //Criteria for String, StringBuilder, ...
        stringLike.addCriteria(new Criteria() {
            @Override
            public boolean accepts(Class<?> type) {
                return type.isAssignableFrom(CharSequence.class);
            }
        });

        stringLike.addCriteria(new WrapperPrimitive(char.class));
        stringLike.addCriteria(new WrapperPrimitive(Character.class));

        return stringLike;
    }

    /**
     * Checks if it is a iterable type (List, ArrayList, ...).
     * @return the Criteria
     */
    public static Criteria iterableType() {
        return new Criteria() {

            @Override
            public boolean accepts(Class<?> type) {
                return type.isAssignableFrom(Iterable.class);
            }
        };
    }
}
