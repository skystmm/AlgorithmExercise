package com.skystmm.lintcode.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: skystmm
 * @date: 2020/1/7 23:49
 */
public class LFUCacheOther {
    private class LFUNode{
        int key;
        int val;
        int count=1;
        long version;
        private LFUNode(int key,int val) {
            this.key=key;
            this.val = val;
        }
    }
    Map<Integer,LFUNode> data=new HashMap<>();
    PriorityQueue<LFUNode> q;
    int capacity;
    long opVersion=0;//global operation version
    public LFUCacheOther(int capacity) {
        if(capacity<=0) return;
        this.capacity=capacity;
        q=new PriorityQueue<>((x,y)->
                x.count==y.count?Long.compare(x.version,y.version):x.count-y.count
        );
    }

    public int get(int key) {
        if(capacity<=0) return -1;
        else{
            LFUNode tmp=data.get(key);
            if(tmp==null) return -1;
            update(tmp,false);
            return tmp.val;
        }
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        if(data.containsKey(key)){
            LFUNode tmp=data.get(key);
            tmp.val=value;
            update(tmp,false);
        }else{
            if(data.size()==capacity){
                LFUNode tmp=q.poll();
                data.remove(tmp.key);
            }
            LFUNode node=new LFUNode(key,value);
            data.put(key,node);
            update(node,true);
        }
    }

    //private method helps improve performance
    private void update(LFUNode node,boolean put){
        ++opVersion;
        ++node.count;
        node.version=opVersion;
        if(!put) q.remove(node);//get or update operation
        q.add(node);
    }
}
