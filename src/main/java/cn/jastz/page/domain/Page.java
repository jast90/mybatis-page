package cn.jastz.page.domain;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 分页的具体实现
 *
 * @author zhiwen
 */
public class Page<T> extends AbstractSlice<T> implements IPage<T> {

    private final long total;
    private final Pageable pageable;

    public Page() {
        this(Lists.newArrayList(), PageRequest.of(1, 15), 0);
    }

    public Page(List<T> content, Pageable pageable, long total) {
        super(content, pageable);
        this.pageable = pageable;
        //TODO 计算总记录数逻辑完善
        this.total = total;
    }

    @Override
    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    @Override
    public long getTotalElements() {
        return total;
    }

    @Override
    public boolean hasNext() {
        return getNumber() + 1 < getTotalPages();
    }

    @Override
    public boolean isLast() {
        return !hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return getNumber() - 1 != 0;
    }

}
