package com.Models;
import com.Context;
import com.Models.IBaseModel;
import com.Models.ISection;

import java.util.LinkedList;
import java.util.List;

public class ForModel extends BaseSection implements IBaseModel {
    private List<IBaseModel> list = new LinkedList<IBaseModel>();
    private IBaseModel firstExpression;
    private IBaseModel endExpression;
    private IBaseModel changeExpression;

    public ForModel(ISection parent) {
        super(parent);
    }

    public ForModel setExpressions(IBaseModel firstExpression, IBaseModel endExpression, IBaseModel changeExpression){
        this.firstExpression = firstExpression;
        this.endExpression = endExpression;
        this.changeExpression = changeExpression;
        return this;
    }
    @Override
    public Object onRun() {
        IBaseModel baseModel = null;
        for(firstExpression.onRun();;changeExpression.onRun()){
            try {
                for (IBaseModel a : list) {
                    try {
                        a.onRun();
                    } catch (Exception e) {
                        if (e.getMessage().equals("continute")) {
                            break;
                        }
                        if (e.getMessage().equals("break")) {
                            throw new Exception("sad");
                        }
                    }
                }
                endExpression.onRun();
            }catch (Exception e){
                if (e.getMessage().equals("sad")) {
                    break;
                }
            }
        }
        return null;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public Context getParentContext() {
        return parent.getParentContext();
    }

    public static void main(String[] args) {
        Context context = new Context();
        ForModel formodel = new ForModel(null);
        IBaseModel firstExpression = new IBaseModel() {
            @Override
            public Object onRun() {
                Integer i = 1;
                context.addValue("i",i,Integer.class);
                return true;
            }
        };
        IBaseModel endExpression = new IBaseModel() {
            @Override
            public Object onRun() {
                if((Integer)context.getValueByName("i")>10){
                    throw new RuntimeException("sad");
                }
                return null;
            }
        };
        IBaseModel changeExpression = new IBaseModel() {
            @Override
            public Object onRun() {
                Integer a =(Integer) context.getValueByName("i");
                System.out.println(a);
                a++;
                context.changeValue("i",a);
                return null;
            }
        };
        formodel.setExpressions(firstExpression,endExpression,changeExpression).onRun();
    }
}
