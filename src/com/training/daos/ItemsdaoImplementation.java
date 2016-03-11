package com.training.daos;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import com.training.domains.Items;
import com.training.ifaces.MyDAO;
import com.training.utils.ItemsRowMapper;

public class ItemsdaoImplementation extends JdbcDaoSupport implements MyDAO<Items>{

	@Override
	public Items find(int key) {
		String sql = "SELECT * FROM ITEMS2016 WHERE  ITEMID= ?";
		Items items = getJdbcTemplate().queryForObject(sql,new ItemsRowMapper(),key);
		return items;
	}

	@Override
	public boolean add(Items t) {
		boolean result = false;
		String sql = "INSERT INTO ITEMS2016 VALUES(?,?,?)";
		int rowInserted = getJdbcTemplate().update(sql,t.getItemId(),t.getItemName(),t.getItemType());
		if(rowInserted>0)
		{
			result = true;
		}
		return result;
	}

	@Override
	public List<Items> findAll() {
		String sql = "SELECT * FROM ITEMS2016";
		List<Items> itemList = getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Items>(Items.class));
		return itemList;
	}

	

}
