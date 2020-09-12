package com.Models;
import com.Context;
public interface ISection {
    public Context getContext();
    public Context getParentContext();
    public Object getObjectByName(String name);
    public Class getTypeByName(String name);
    public void CreatObjectOnthisContext(String name,Object value,Class c);
}
