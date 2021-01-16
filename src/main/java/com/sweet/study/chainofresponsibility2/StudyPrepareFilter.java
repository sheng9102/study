package com.sweet.study.chainofresponsibility2;

import com.sweet.study.chainofresponsibility1.PreparationList;

public interface StudyPrepareFilter {
    public void doFilter(PreparationList preparationList, FilterChain filterChain);
}
