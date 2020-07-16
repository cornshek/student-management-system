package com.zl.daoconfig.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;

/**
 * MybatisPlus的配置类
 * @author THINK
 *
 */
@Configuration
//@EnableTransactionManagement
public class MybatisPlusConfig {
	
	//配置一个分页插件
	@Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
	
	//配置序列生成器
	@Bean
	public IKeyGenerator keyGenerator() {
	    return new OracleKeyGenerator();
	}
}
