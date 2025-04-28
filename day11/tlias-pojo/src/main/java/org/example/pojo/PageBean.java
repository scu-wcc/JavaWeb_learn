package org.example.pojo;

import java.util.List;

@SuppressWarnings("ALL")
public class PageBean {
    private Long total;
    private List rows;


    public PageBean() {
    }

    public PageBean(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    /**
     * 获取
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取
     * @return rows
     */
    public List getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageBean{total = " + total + ", rows = " + rows + "}";
    }
}
