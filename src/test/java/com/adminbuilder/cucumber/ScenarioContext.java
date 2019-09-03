package com.adminbuilder.cucumber;

import java.util.HashMap;
import java.util.Map;

import com.adminbuilder.enums.Contextenum;

public class ScenarioContext {

	private  Map<String, Object> scenarioContext;
	 
    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(Contextenum key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Contextenum key){
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Contextenum key){
        return scenarioContext.containsKey(key.toString());
    }
}
