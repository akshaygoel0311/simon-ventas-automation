package com.simonventas.automation.commons.methods.web.factory;
import com.simonventas.automation.commons.methods.web.WebGlobalMethods;
import org.json.simple.JSONObject;

public class WebMethodsFactory {
    public static WebGlobalMethods getMethods(JSONObject json){
        return  new WebGlobalMethods(json);
    }
}