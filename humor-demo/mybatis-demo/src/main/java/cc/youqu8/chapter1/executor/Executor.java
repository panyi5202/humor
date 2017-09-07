package cc.youqu8.chapter1.executor;

import cc.youqu8.chapter1.executor.result.ResultHandler;
import cc.youqu8.chapter1.mapping.MappedStatement;
import cc.youqu8.chapter1.session.RowBounds;



import java.util.List;

/**
 * 执行器
 * @author panyi on 17-9-4.
 * @since V0.0.1
 */
public interface Executor {
    <E> List<E> query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler);
}
