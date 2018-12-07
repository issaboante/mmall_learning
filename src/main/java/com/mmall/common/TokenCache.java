package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static String TOKEN_PREFIX = "token_";

    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder()
            .initialCapacity(1000).maximumSize(10000).expireAfterAccess(24, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                // 默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
                @Override
                public String load(String s) throws Exception {
                    return null;
                }
            });

    public static String getKey(String key) {
        try {
            return localCache.get(key);
        } catch (ExecutionException e) {
            logger.error("localCache get error", e);
        }
        return null;
    }

    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }
}
