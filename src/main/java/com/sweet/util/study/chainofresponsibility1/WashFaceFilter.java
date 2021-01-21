package com.sweet.util.study.chainofresponsibility1;

public class WashFaceFilter extends AbstractPrepareFilter {

    public WashFaceFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashFace()) {
            System.out.println("洗脸");
        }

    }

}
