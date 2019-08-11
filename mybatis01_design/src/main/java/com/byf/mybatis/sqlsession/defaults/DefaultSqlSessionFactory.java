package com.byf.mybatis.sqlsession.defaults;

import com.byf.mybatis.cfg.Configuration;
import com.byf.mybatis.sqlsession.SqlSession;
import com.byf.mybatis.sqlsession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
