package com.Models;

public class AddModel implements IBaseModel{
    public ISection parent;
    String nameA;
    String nameB;
    public AddModel(ISection parent,String nameA,String nameB){
        this.parent = parent;
    }
    @Override
    public Object onRun() {
        parent.getContext();
        return null;
    }
}
