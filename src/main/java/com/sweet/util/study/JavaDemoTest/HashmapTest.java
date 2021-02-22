package com.sweet.util.study.JavaDemoTest;

import java.util.HashMap;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class HashmapTest {
    public static void main(String[] args) {
        // 初始容量测试 会开辟最接近的2的n次方，会大于等于给定值
        HashMap<String,String> hashmap = new HashMap(1+(int)(3/0.75));
        hashmap.put("aaa1","111");
        hashmap.put("bbb2","222");
        hashmap.put("ccc3","333");
        hashmap.put("ddd4","444");


        System.out.println(hashmap.size());

    }

}
