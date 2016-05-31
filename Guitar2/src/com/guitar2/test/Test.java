package com.guitar2.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.guitar2.model.*;
import com.guitar2.util.*;

public class Test {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		List guitars = new ArrayList();
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from guitar2";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Guitar guitar = new Guitar();
			GuitarSpec gs = new GuitarSpec();
			gs.setBuilder(builder.valueOf(rs.getString("builder")));
			gs.setBackWood(wood.valueOf(rs.getString("backwood")));
			gs.setTopWood(wood.valueOf(rs.getString("topwood")));
			gs.setModel(rs.getString("model"));
			gs.setType(type.valueOf(rs.getString("type")));
			guitar.setPrice(rs.getDouble("price"));
			guitar.setSerialNumber(rs.getString("serialNumber"));
			guitar.setGuitarSpec(gs);
			guitars.add(guitar);
		}
		inventory.setGuitars(guitars);
		Guitar tg = new Guitar();
		GuitarSpec guitarSpec = new GuitarSpec();
		guitarSpec.setType(type.b);
		tg.setGuitarSpec(guitarSpec);
		inventory.FindGuitars(tg);
		System.out.print("您好！这是一个测试程序");
		System.out.print(inventory.FindGuitars(tg).size());
	}
}
