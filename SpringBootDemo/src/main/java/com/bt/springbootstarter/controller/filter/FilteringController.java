package com.bt.springbootstarter.controller.filter;

import com.bt.springbootstarter.beans.FilterBean;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveFilterBean(){
        
        FilterBean bean =  new FilterBean("value1","value2","value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterBeanFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(bean);
        
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveFilterBeanList(){
       List<FilterBean> list =  Arrays.asList(new FilterBean("value1","value2","value3"),
                new FilterBean("value12","value22","value32"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterBeanFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(list);

        mapping.setFilters(filters);
        return mapping;
    }
}
