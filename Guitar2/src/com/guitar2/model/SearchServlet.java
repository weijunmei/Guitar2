package com.guitar2.model;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar2.model.Guitar;
import com.guitar2.model.GuitarSpec;
import com.guitar2.model.Inventory;
import com.guitar2.model.builder;
import com.guitar2.model.type;
import com.guitar2.model.wood;
import com.guitar2.util.DBUtil;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		PreparedStatement pstmt = null;
		Inventory inventory = new Inventory();
		List guitars = new ArrayList();
		String sql = "select * from guitar2";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Guitar guitar = new Guitar();
				GuitarSpec guitarspec = new GuitarSpec();
				guitarspec.setBuilder(builder.valueOf(rs.getString("builder")));
				guitarspec.setModel(rs.getString("model"));
				guitarspec.setType(type.valueOf(rs.getString("type")));
				guitar.setPrice(rs.getDouble("price"));
				guitarspec.setBackWood(wood.valueOf(rs.getString("backwood")));
				guitarspec.setTopWood(wood.valueOf(rs.getString("topwood")));		
				guitar.setSerialNumber(rs.getString("serialNumber"));
				guitar.setGuitarSpec(guitarspec);
				guitars.add(guitar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventory.setGuitars(guitars);
		String model1 = null, builder1 = null, type1 = null, backwood1 = null, topwood1 = null;
		Guitar tg = new Guitar();
		GuitarSpec guitarSp = new GuitarSpec();
		if (!request.getParameter("model").equals("")) {
			model1 = request.getParameter("model");
			guitarSp.setModel(model1);
		}
		if (request.getParameter("type") != null) {
			type1 = request.getParameter("type");
			guitarSp.setType(type.valueOf(type1));
		}
		if (request.getParameter("builder") != null) {
			builder1 = request.getParameter("builder");
			guitarSp.setBuilder(builder.valueOf(builder1));
		}
		if (request.getParameter("backwood") != null) {

			backwood1 = request.getParameter("backwood");
			guitarSp.setBackWood(wood.valueOf(backwood1));
		}
		if (request.getParameter("topwood") != null) {
			topwood1 = request.getParameter("topwood");
			guitarSp.setTopWood(wood.valueOf(topwood1));
		}
		tg.setGuitarSpec(guitarSp);
		inventory.FindGuitars(tg);
		inventory.setGuitars(inventory.FindGuitars(tg));
		request.setAttribute("result", inventory);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
