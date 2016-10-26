package com.dhc.dto;

import java.io.Serializable;

/**
 * Created by DuHongcai on 2016/10/25.
 */
public class OrderParam implements Serializable{

    private int offset;
    private int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
