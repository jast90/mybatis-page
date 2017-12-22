package cn.jastz.page.domain;

import java.io.Serializable;

/**
 * @author zhiwen
 */
public abstract class AbstractPageRequest implements Pageable, Serializable {

    private final int page;
    private final int size;

    public AbstractPageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public long getOffset() {
        return page * size;
    }

    @Override
    public boolean hasPrevious() {
        return page > 0;
    }

    @Override
    public abstract Pageable next();

    @Override
    public abstract Pageable previousOrFirst();

    @Override
    public abstract Pageable first();


}
