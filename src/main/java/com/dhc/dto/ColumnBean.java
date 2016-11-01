package com.dhc.dto;

import java.io.Serializable;

/**
 * Created by DuHongcai on 2016/10/31.
 */
public class ColumnBean implements Serializable{
    /**
     * Excle表头字段类
     */
    private String filed;
    private String value;
    private String title;
    private Integer width = 120;
    private String align="center";
    private Integer colspan;
    private Boolean hidden;
    private Integer lineNumber;
    private Integer row;
    private Integer col;
    private String fieldType = "String";

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public ColumnBean() {
    }

    public ColumnBean(String title, String filed) {
        this.title = title;
        this.filed = filed;
    }

    public ColumnBean(String filed, Integer width, String title) {
        this.filed = filed;
        this.width = width;
        this.title = title;
    }

    public ColumnBean(String filed, String align, Integer width, String title) {
        this.filed = filed;
        this.align = align;
        this.width = width;
        this.title = title;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public Integer getColspan() {
        return colspan;
    }

    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }
}
