package com.sm_kitchen.service;

import java.util.List;

import com.sm_kitchen.bean.Table;

public interface TableService {
   List<Table> getAllTables() throws Exception;
   Table getTableinfo(Integer tableid) throws Exception;
}
