package com.ag.grid.enterprise.sql.demo.controller;

import com.ag.grid.enterprise.sql.demo.aggridlib.filter.ColumnFilter;
import com.ag.grid.enterprise.sql.demo.aggridlib.filter.NumberColumnFilter;
import com.ag.grid.enterprise.sql.demo.aggridlib.filter.SetColumnFilter;
import com.ag.grid.enterprise.sql.demo.aggridlib.request.EnterpriseGetRowsRequest;
import com.ag.grid.enterprise.sql.demo.aggridlib.request.FilterRequest;
import com.ag.grid.enterprise.sql.demo.aggridlib.response.EnterpriseGetRowsResponse;
import com.ag.grid.enterprise.sql.demo.dao.TradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TradeController {

    private TradeDao tradeDao;

    @Autowired
    public TradeController(@Qualifier("tradeDao") TradeDao tradeDao) {
        this.tradeDao = tradeDao;
    }

    @RequestMapping(method = POST, value = "/getRows")
    @ResponseBody
    public EnterpriseGetRowsResponse getRows(@RequestBody EnterpriseGetRowsRequest request) {
        return tradeDao.getData(request);
    }

    @RequestMapping(method = POST, value = "/getFilters")
    @ResponseBody
    public List<String> getFilters(@RequestBody FilterRequest request) {

        System.out.println("asdfasdfadsf");

        Map<String, ColumnFilter> filterModel = request.getFilterModel();
//
//        filterModel.forEach((key, value) -> {
//            print(value);
//        });

        return Arrays.asList("Buy1", "Sell1");
    }

    private void print(SetColumnFilter filter) {
        System.out.println("setFilter with values: " + filter.getValues());
    }

    private void print(NumberColumnFilter filter) {
        System.out.println("numberFilter with filter: " + filter.getFilter());
    }

//    private void print(ColumnFilter filter) {
//        System.out.println("default");
//
//    }

}