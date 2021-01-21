package com.sweet.util.study.chainofresponsibility2;

import com.sweet.util.study.chainofresponsibility1.PreparationList;

public class WashHairFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isWashHair()) {
            System.out.println("洗完头发");
        }

        filterChain.doFilter(preparationList, filterChain);
    }

}
