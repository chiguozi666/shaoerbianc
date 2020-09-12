package com.Models;

/**
 * 负责实现IBaseModel，继承这个类，可以调用
 */
public abstract class BaseModelImpl implements IBaseModel {
    private ISection parent;
    public BaseModelImpl(ISection parent) {
        this.parent = parent;
    }

    @Override
    public Object onRun() {
        return null;
    }
    public ISection getParent(){
        return parent;
    }
}
