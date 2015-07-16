package net.javabeat.primefaces.cache;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;

import com.ibm.websphere.cache.DistributedObjectCache;
import com.ibm.websphere.cache.EntryInfo;


@Stateless
public class ProcessCacheService {

    protected static final int PROCESS_TTL = 4 * 60 * 60; // 4 hours
    private static final int DEFAULT_TTL = 60;

    @Resource(name = "services/mars/cache/process", mappedName = "services/mars/cache/process")
    public DistributedObjectCache processCache;

    @PostConstruct
    private void init() {
    	System.out.println(".... Init Cache..."); 	
    	processCache.setPriority(1);
    	processCache.setTimeToLive(DEFAULT_TTL);
    	processCache.setSharingPolicy(EntryInfo.SHARED_PUSH);
        System.out.println(".... Init Cache done...");
    }

    
    public void clearFreeProcess(String key) {
    	if(processCache.get(key) != null) {
    		processCache.remove(key);
    	}
    }
    
    public Object getFreeProcess(String key) {
        return processCache.get(key);
    }

    
    public boolean setFreeProcess(String key, Object value) {
    	boolean result = true;
    	if(processCache.get(key) != null) {
    		result = false;
    	}
    	else {
    		//processCache.put(key, value, 1, PROCESS_TTL, EntryInfo.SHARED_PUSH,
            //        null);
    		processCache.put(key, value, 1, DEFAULT_TTL, EntryInfo.SHARED_PUSH,
                    null);
    	}
    	return result;
    	
    }

   

   
}