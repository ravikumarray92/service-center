package com.training.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.domains.Items;

public class ItemsRowMapper implements RowMapper<Items> {

	@Override
	public Items mapRow(ResultSet rs, int rowCount) throws SQLException {
		Items items = new Items();
		items.setItemId(rs.getInt(1));
		items.setItemType(rs.getString(2));
		items.setItemName(rs.getString(3));
		return items;
	}

}
