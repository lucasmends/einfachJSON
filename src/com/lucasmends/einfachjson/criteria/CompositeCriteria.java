/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasmends.einfachjson.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which check if it matches with anyone in a list of criterias.
 * 
 * @author lucas
 */
public final class CompositeCriteria implements Criteria{

    private final List<Criteria> criterias;
    
    public CompositeCriteria(){
        this.criterias = new ArrayList<>();
    }
    
    /**
     * Add more Criterias for it compares
     * @param criteria the criteria for it check
     */
    public void addCriteria(Criteria criteria){
        this.criterias.add(criteria);
    }
    
    @Override
    public boolean accepts(Class<?> type) {

        for(Criteria criteria: criterias){
            if(criteria.accepts(type)){
                return true;
            }
        }
        
        return false;
    }
    
}
