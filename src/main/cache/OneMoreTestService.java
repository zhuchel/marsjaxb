package net.javabeat.primefaces.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import net.javabeat.primefaces.cache.ProcessCacheService;

@Stateless
public class OneMoreTestService {

	@Inject
	ProcessCacheService cacheService;

	public void putToCache() {
		boolean result = cacheService.setFreeProcess("hui",
				String.valueOf(System.currentTimeMillis()));
		if (!result) {
			System.out
					.println("OneMoreTestService->Key 'hui' is already in cache");
		} else {
			System.out
					.println("OneMoreTestService->Key 'hui' is is placed into cache");
		}
	}

	public String getFromCache() {
		Object value = cacheService.getFreeProcess("hui");
		return value == null ? null : (String) value;
	}

	public void clearCache() {
		cacheService.clearFreeProcess("hui");
	}

}
