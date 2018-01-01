package cn.jastz.page.mybatis;

import cn.jastz.page.domain.PageRequest;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author zhiwen
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Page plugin");
        PageRequest pageRequest = null;
        PageResultHandler pageResultHandler = null;
        RowBounds rowBounds = null;
        try {
            pageRequest = (PageRequest) invocation.getArgs()[1];
            rowBounds = (RowBounds) invocation.getArgs()[2];
            pageResultHandler = (PageResultHandler) invocation.getArgs()[3];
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (pageRequest != null && pageResultHandler != null) {
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
