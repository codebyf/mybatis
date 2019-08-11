package com.byf.mybatis.sqlsession;

public interface SqlSession {
    /**
     *
     * @param daoInterfaceClass : dao接口的字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
