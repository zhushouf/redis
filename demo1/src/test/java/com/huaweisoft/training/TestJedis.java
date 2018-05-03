package com.huaweisoft.training;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestJedis {

	private static final Logger log = Logger.getLogger(TestJedis.class);

	/**
	 * 测试连接
	 */
	@Test
	public void test1() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("123456");

		log.info("连接成功");
		log.info("服务正在运行：" + jedis.ping());
	}

	/**
	 * Redis Java String(字符串) 实例
	 */
	@Test
	public void test2() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("123456");

		// 设置 redis 字符串数据
		jedis.set("runoobkey", "www.runoob.com");
		// 获取存储的数据并输出
		log.info("redis 存储的字符串为: " + jedis.get("runoobkey"));
	}

	/**
	 * Redis Java List(列表) 实例
	 */
	@Test
	public void test3() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.auth("123456");

		// 存储数据到列表中
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("site-list", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			log.info("列表项为: " + list.get(i));
		}
	}

}