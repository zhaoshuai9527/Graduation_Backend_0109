package com.topic.test;

import com.topic.util.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private Logger logger= LoggerFactory.getLogger(Test.class);


    private static int stock = 1000;

    @Autowired
    RedisLock redisLock;

    /**
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/seck/{userId}/{topicId}")

    public String  decrementProductStore(@PathVariable String userId,@PathVariable String topicId) {
        System.out.println("抢题秒杀");
        String key = "抢题秒杀";
        long time = System.currentTimeMillis();
        try {
            //如果库存为空
            if (stock == 0) {
                logger.info("库存为0啦，请稍后重试");
                return "库存为0啦，请稍后重试！";

            }
            //如果加锁失败
            if (!redisLock.lock(key, String.valueOf(time))) {
                logger.info("人太多啦,请稍后再试！");
                return "人太多啦,请稍后再试！";
            }

            //减库存操作
            stock--;
            logger.info("题目{}选择成功，用户{}选择成功，还剩下{}",topicId,userId,stock);
        } catch (Exception e) {
            logger.info("选题失败{}",e.getMessage());
            e.printStackTrace();
        } finally {
            //解锁
            redisLock.unLock(key, String.valueOf(time));
        }

        return "抢单成功";
    }

}
