package com.topic.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisLock {
    private static Logger logger = LoggerFactory.getLogger(RedisLock.class);


    @Autowired
    RedisUtil redisUtil;

    public static Long expire = 30L;

    /**
     * @param key   redis的key
     * @param value redis中的value，由当前时间+自定义过期时间组成
     * @return
     */
    public boolean lock(String key, String value) {
        boolean isLock = redisUtil.setnx(key, value,expire);
        if (isLock) {
            //如果缓存中key不存在，则存入，value值默认是当前时间加上自定义时间
            return true;
        }
        return false;
    }


    /**
     * redis解锁操作
     * @param key
     * @param value
     * @return
     */
    public void unLock(String key, String value) {
        //获取redis的value
        try {
            String curValue = String.valueOf(redisUtil.get(key));
            if(!StringUtils.isEmpty(curValue) && curValue.equals(value)){
                //说明是同一个操作的人来解锁
                redisUtil.del(key);
            }
        }catch (Exception e){
            logger.error("Redis解锁异常{}",e.getMessage());
        }

    }
}
