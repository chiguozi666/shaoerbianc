package com;

import java.util.HashMap;

public class Context {
    HashMap<String,Class> name_type = new HashMap<>();
    HashMap<String,Object>name_value = new HashMap<>();
    public Object getValueByName(String name){
        return name_value.get(name);
    }
    public Object getClassByName(String name){
        return name_type.get(name);
    }
    public void addValue(String name,Object value,Class c){
        if(name==null||value==null||c==null){
            throw new RuntimeException("Context传入参数不能为空");
        }
        if(name_type.get(name)!=null&&name_value.get(name)!=null){
            throw new RuntimeException("Context当前已存在相同的变量:"+name);
        }
        name_value.put(name,value);
        name_type.put(name,c);
    }
    public void changeValue(String name,Object value){
        if(name==null||value==null){
            throw new RuntimeException("Context传入参数不能为空");
        }
        if(name_type.get(name)==null||name_value.get(name)==null){
            throw new RuntimeException("当前参数未定义:"+name);
        }
        name_value.replace(name,value);
    }
}
