package com.sm_kitchen.dao;

import java.util.List;

import com.sm_kitchen.bean.Table;

public interface TableDao {
   List<Table> selectAll();
   Table selectDishByTableID(Integer tableId);
}
