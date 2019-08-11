package com.byf.mybatis.sqlsession;

import com.byf.mybatis.cfg.Configuration;
import com.byf.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.byf.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    /**
     * 根据入参解析xml
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
