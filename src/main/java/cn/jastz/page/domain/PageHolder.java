package cn.jastz.page.domain;

import com.google.common.collect.Lists;

public class PageHolder {
    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    public static Page getPage() {
        if (pageThreadLocal.get() == null) {
            return new PageImpl();
        }
        return pageThreadLocal.get();
    }

    public static void setPage(Page page) {
        pageThreadLocal.set(page);
    }
}
