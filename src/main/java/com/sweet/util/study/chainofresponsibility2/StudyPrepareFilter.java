package com.sweet.util.study.chainofresponsibility2;

import com.sweet.util.study.chainofresponsibility1.PreparationList;

public interface StudyPrepareFilter {
    public void doFilter(PreparationList preparationList, FilterChain filterChain);
}
