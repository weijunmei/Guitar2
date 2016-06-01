<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.guitar2.util.DBUtil" %>
<%@ page import="com.guitar2.model.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
</head>
<body bgcolor="#8B636C">
<br>
<br>
<br>
<font color='white'>查询结果：</font>
<table style="text-align:center ;" border="0" bgcolor="#FFF5EE">
<br>
<thead>
<tr>
<th style="width:80px;">产品序号</th>
<th style="width:80px;">产品价格</th>
<th style="width:80px;">制造商家</th>
<th style="width:80px;">产品模型</th>
<th style="width:80px;">产品种类</th>
<th style="width:80px;">吉他前木</th>
<th style=";width:80px;">吉他后木</th>
</tr>
</thead>
<tbody>
	<% 
		Inventory inventory = new Inventory();
		inventory = (Inventory)request.getAttribute("result");
		List guitars = new ArrayList();
		guitars = inventory.getGuitars();
		System.out.print(guitars.size());
		if(guitars.size()>0){
		Iterator i = guitars.iterator();
		while(i.hasNext()){
			Guitar guitar = (Guitar) i.next();
		 %>
		 <tr  > <td > <%=guitar.getSerialNumber() %> </td>
		  <td> <%=guitar.getPrice() %></td>
		 <td><%=guitar.getGuitarSpec().getBuilder() %></td>
		 <td><%=guitar.getGuitarSpec().getModel() %></td>
		 <td><%=guitar.getGuitarSpec().getType() %></td>
		  <td><%=guitar.getGuitarSpec().getBackWood() %> </td>
		 <td> <%=guitar.getGuitarSpec().getTopWood() %> </td> </tr>
		 <%}%>	
		 <%}else{%>
		<font color='white'>您查询的结果不存在，请核实后重新查找！</font>
		<% 	}%>
	</tbody>
</table>
</body>
</html>