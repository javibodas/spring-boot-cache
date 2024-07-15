package com.jgb.configuration;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.stereotype.Component;

/*
 * This class can be used to customize the type of the cache manager (ConcurrentMapCacheManager by default) when using spring boot cache starter
 * In this case, it is used Caffeine as cache manager
 */
@Component
public class CacheCustomizer implements CacheManagerCustomizer<CaffeineCacheManager> {

    @Override
    public void customize(CaffeineCacheManager cacheManager) {}
}
