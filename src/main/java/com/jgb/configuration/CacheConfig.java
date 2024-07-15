package com.jgb.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    /*
     * This bean is used to define the cache manager when not having spring boot cache starter
     * It is also mandatory to define the cache names
     * With spring boot cache starter and @EnableCaching it is not necessary to define cache manger nor cache names

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("stephenKingBooks")));
        return cacheManager;
    }*/

    /**
     * Only for caffeine cache
     * It also be configured via parameters: spring.cache.caffeine.spec

    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder();//.expireAfterWrite(1, TimeUnit.MINUTES);
    }*/
}
