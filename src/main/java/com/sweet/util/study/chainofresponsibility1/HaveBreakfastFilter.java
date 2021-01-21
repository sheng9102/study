package com.sweet.util.study.chainofresponsibility1;

public class HaveBreakfastFilter extends AbstractPrepareFilter {

    public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃早餐");
        }

    }

}
