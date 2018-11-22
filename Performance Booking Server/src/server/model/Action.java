/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.model;

import java.io.Serializable;

/**
 *
 * @author harry
 */
public class Action implements Serializable{

    private static final long serialVersionUID = 707337248096726373L;

    
    /**
     *
     */
    public String desc;
    
    /**
     *
     */
    public Object obj;

    /**
     *
     * @param desc
     * @param obj
     */
    public Action(String desc, Object obj){
        this.desc = desc;
        this.obj = obj;
    }    
}
