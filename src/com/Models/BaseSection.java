package com.Models;

import com.Context;

public class BaseSection implements ISection{
    Context context;
    ISection parent;
    public BaseSection(ISection parent) {
        this.parent = parent;
        context = new Context();
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public Context getParentContext() {
        return parent.getParentContext();
    }

    @Override
    public Object getObjectByName(String name) {
        Object result = context.getValueByName(name);
        if(result==null){
            if(parent!=null){
                //向上递归
                result = parent.getObjectByName(name);
            }
        }
        return result;
    }

    @Override
    public Class getTypeByName(String name) {
        Class result = (Class) context.getClassByName(name);
        if(result==null){
            if(parent!=null){
                //向上递归
                result = parent.getTypeByName(name);
            }
        }
        return result;
    }

    @Override
    public void CreatObjectOnthisContext(String name, Object value, Class c) {
        context.addValue(name,value,c);
    }
}
