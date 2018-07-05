package com.skystmm.hashtable;

import java.util.*;

/**
 * 811. Subdomain Visit Count
 * Created by sky on 2018/3/10.
 */
public class SubdomainVisitCount {

    /**
     * AC cost: 66 ms beats: 21.38 %
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if(cpdomains != null && cpdomains.length > 0){
            List<String> domains = Arrays.asList(cpdomains);
            Map<String,Long> domainMap = new HashMap<>();
            domains.forEach(item->{
                String[] tmp = item.split(" ");
                Long  count = Long.parseLong(tmp[0]);
                String whole = tmp[1];
                getAllDomain(whole).forEach(url ->{
                    if(domainMap.containsKey(url)){
                        domainMap.put(url,domainMap.get(url) + count);
                    }else{
                        domainMap.put(url,count);
                    }
                });
            });

            domainMap.forEach((key,value)->{
                String tmp = value + " " + key;
                result.add(tmp);
            });
        }
        return result;
    }

    private Set<String> getAllDomain(String url){
        Set<String> sets = new HashSet<>();
        sets.add(url);
        while(url.contains(".")){
            int i = url.indexOf(".");
            if(i >0){
                url = url.substring(i+1);
                sets.add(url);
            }
        }
        return sets;
    }
}
