package com.skystmm.lintcode.cache;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 24. LFU Cache
 * NAC 60% pass
 * use map and heap sort
 * @author: skystmm
 * @date: 2020/1/6 11:12
 */
public class LFUCache {

    private HashMap<Integer,Integer> cache;

    private int capacity;

    private List<Rate> rates;
    /*
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        if(capacity < 1){
            throw new IllegalArgumentException("capacity should be gatter than 0");
        }
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.rates = initRates(capacity);
    }

    private List<Rate> initRates(int capacity) {
        List<Rate> rates = new ArrayList<>();
        int i =0;
        while(i< capacity){
            rates.add(new Rate());
            i++;
        }
        return  rates;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(cache.containsKey(key)){
            cache.put(key, value);
        }else{
            if(cache.size() == capacity){
                Rate head =   rates.get(0);
                cache.remove(head.key);
            }
            cache.put(key, value);
            insertRate(key);
        }
    }



    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(cache.containsKey(key)){
            updateRate(key);
            return  cache.get(key);
        }
        return  -1;
    }


    /**
     * 插入新元素访问
     * @param key
     */
    private void insertRate(int key) {
        Rate newRate = new Rate(key);
        rates.set(0,newRate);

        int index = 0;
        while(index < rates.size()){
            int lIndex = index * 2 + 1;
            if(lIndex < rates.size()){
                if(lIndex + 1 < rates.size() && rates.get(lIndex).count >= rates.get(lIndex +1).count){
                    lIndex ++;
                }
                if(rates.get(index).count >= rates.get(lIndex).count){
                    Rate tmp = rates.get(index);
                    rates.set(index, rates.get(lIndex));
                    rates.set(lIndex, tmp);
                    index = lIndex;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
    }

    /**
     * 元素更新
     * @param key
     */
    private void updateRate(int key) {
        int lIndex = -1;
        int rIndex = rates.size()-1;
        Rate tmp =null;
        for(int i =0 ;i<rates.size();i++){
            if(lIndex < 0){
                if(key == rates.get(i).key){
                    lIndex = i;
                    rates.get(i).count++;
                }
            }else{
                if(rates.get(lIndex).count == rates.get(i).count){
                    rIndex = i;
                    break;
                }
            }

        }
        if( lIndex > -1 && lIndex < rIndex){
            Rate cur = rates.get(lIndex);
            for(int i = lIndex; i < rIndex ; i++){
                rates.set(i, rates.get(i+ 1));
            }
            rates.set(rIndex,cur );
        }

        //heapCompare(index);
    }

    private void heapCompare(int index){
        while(index < rates.size()){
            int lIndex = index * 2 + 1;
            if(lIndex < rates.size()){
                if(lIndex + 1 < rates.size() && rates.get(lIndex).count > rates.get(lIndex +1).count){
                    lIndex ++;
                }
                if(rates.get(index).count >= rates.get(lIndex).count){
                    Rate tmp = rates.get(index);
                    rates.set(index, rates.get(lIndex));
                    rates.set(lIndex, tmp);
                    index = lIndex;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
    }

    final class Rate {
        private Integer key;
        private int count=Integer.MIN_VALUE;

        public Rate() {
            key = Integer.MIN_VALUE;
        }

        public Rate(Integer key) {
            this.key = key;
            this.count = 1;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        System.out.println(cache.get(1));
        cache.set(4, 40);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.set(5, 50);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}