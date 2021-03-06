package com.sweet.util.study.chainofresponsibility2;

import com.sweet.util.study.chainofresponsibility1.PreparationList;
import com.sweet.util.study.chainofresponsibility1.Study;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements StudyPrepareFilter {

    private int pos = 0;

    private Study study;

        private List<StudyPrepareFilter> studyPrepareFilterList;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if (studyPrepareFilterList == null) {
            studyPrepareFilterList = new ArrayList<StudyPrepareFilter>();
        }

        studyPrepareFilterList.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList thingList, FilterChain filterChain) {
        // 所有过滤器执行完毕
        if (pos == studyPrepareFilterList.size()) {
            study.study();
            return;
        }

        studyPrepareFilterList.get(pos++).doFilter(thingList, filterChain);
    }

}
