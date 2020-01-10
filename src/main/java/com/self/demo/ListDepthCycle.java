package com.self.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDepthCycle {
    public static void main(String[] args) {

        Map<String, Object> map1 = new HashMap();
        map1.put( "id","1" );

        Map<String, Object> map2 = new HashMap();
        map2.put( "id","2" );
        map2.put("children",map1);

        Map<String, Object> map3 = new HashMap();
        map3.put( "id","3" );
        map3.put("children",map2);

        Map<String, Object> map4 = new HashMap();
        map4.put( "id","4" );
        map4.put("children",map3);

        Map<String, Object> map5 = new HashMap();
        map5.put( "id","5" );
        map5.put("children",map4);



        Map<String, Object> smap1 = new HashMap();
        smap1.put( "id","s1" );

        Map<String, Object> smap2 = new HashMap();
        smap2.put( "id","s2" );
        smap2.put("children",smap1);

        Map<String, Object> smap3 = new HashMap();
        smap3.put( "id","s3" );
        smap3.put("children",smap2);

        Map<String, Object> smap4 = new HashMap();
        smap4.put( "id","s4" );
        smap4.put("children",smap3);

        Map<String, Object> smap5 = new HashMap();
        smap5.put( "id","s5" );
        smap5.put("children",smap4);

        List<Map<String, Object>> list = new ArrayList();

        list.add( smap5 );
        list.add( map5 );
        int start = 2;
        int end = 3;
        handler(list, start, end,1);
    }


    private static void handler(List<Map<String, Object>> list, int start, int end,int depth) {
        System.out.println(list);
        for (Map<String, Object> map : list){
            if (depth >= start && depth <= end){
                System.out.println(map.get( "id" ));
                depth ++;
                if (map.containsKey( "children" )){
                    List subList = (List)map.get( "children"  );
                    handler(subList, start, end, depth);
                }

            }else if (depth < start){
                depth ++;
                if (map.containsKey( "children" )){
                    List subList = (List)map.get( "children"  );
                    handler(subList, start, end, depth);
                }
            }
        }
    }

}
