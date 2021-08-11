package com.simonventas.automation.commonslocal;

import org.json.simple.JSONObject;

import com.simonventas.automation.commons.methods.web.WebGlobalMethods;

public class BaseComponent  {

   protected WebGlobalMethods methods;

    public  BaseComponent(JSONObject json){
        this.methods = new WebGlobalMethods(json);
    }
}
