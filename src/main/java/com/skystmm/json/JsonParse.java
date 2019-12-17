package com.skystmm.json;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: skystmm
 * @date: 2019/12/15
 */
public class JsonParse {

    private Map<String, Object> cache = new HashMap<>();

    private static final Pattern INDEX_PATTERN = Pattern.compile("(\\[)([0-9][0-9]*)(\\])$");


    public void buildJsonString(String path, Object content) {
        String[] split = path.split("\\.");
        Map<String, Object> curLevel = cache;
        for (int i = 0; i < split.length ; i++) {
            String curKey = split[i];
            if (i == split.length - 1) {
                curLevel.put(curKey, content);
                curLevel = cache;
            }else{
                if(curKey.contains("[")){
                    int index = getIndex(curKey);
                    String key = curKey.substring(0,curKey.indexOf("["));
                    if(curLevel.containsKey(key) && curLevel.get(key) instanceof List){
                        List<Map<String,Object>> curList = (List) curLevel.get(key);
                        if(index < curList.size()){
                            curLevel = curList.get(index);
                        }else{
                            curLevel = new HashMap<>();
                            curList.add(curLevel);
                        }
                    }else{
                        Map<String,Object> innerStruct = new HashMap<>();
                        List<Map<String,Object>> innerList = new ArrayList<>();
                        innerList.add(innerStruct);
                        curLevel.put(key,innerList);
                        curLevel = innerStruct;
                    }
                }else{
                    if(!curLevel.containsKey(curKey)){
                        curLevel.put(curKey,new HashMap<>());

                    }
                    curLevel = (Map<String, Object>) curLevel.get(curKey);


                }
            }
        }

    }

    public void clearCache() {
        cache.clear();
    }

    public String getJsonString(){
        return JSONObject.toJSONString(cache);
    }
    private int getIndex(String key){
        Matcher matcher = INDEX_PATTERN.matcher(key);
        if(matcher.find()){
            return  Integer.parseInt(matcher.group(2));
        }
        return -1;
    }

}
