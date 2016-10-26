package com.dhc.controller;

import com.dhc.gson.GsonView;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DuHongcai on 2016/10/19.
 */
public class BaseController {

    public <T>View toView(Model model, List<T> list){
        Map<String,Object> map = toJsonList(list);
        model.addAttribute("root",map);
        return  new GsonView("root",null);
    }

    protected <T> Map<String,Object> toJsonList(List<T> list){
        Map<String,Object> map = new HashMap<String, Object>();
        if (list instanceof PageList){
            map = generaterMapForList((PageList) list);
        }
        map.put("rows",list);
        return map;
    }

    private <T> Map<String,Object> generaterMapForList(PageList<T> list){
        Map<String,Object> map = new HashMap<String, Object>();
        Paginator paginator = list.getPaginator();
        map.put("total",paginator.getTotalCount());
        map.put("totalPages",paginator.getTotalPages());
        map.put("page",paginator.getPage());
        map.put("limit",paginator.getLimit());
        map.put("rows",new ArrayList(list));

        map.put("startRow",paginator.getStartRow());
        map.put("endRow",paginator.getEndRow());

        map.put("offset",paginator.getOffset());
        map.put("slider",paginator.getSlider());

        map.put("nextPage",paginator.getNextPage());
        map.put("prePage",paginator.getPrePage());

        map.put("firstPage",paginator.isFirstPage());
        map.put("hasNextPage",paginator.isHasNextPage());
        map.put("hasPrePage",paginator.isHasPrePage());
        map.put("lastPage",paginator.isLastPage());
        return map;
    }

}
