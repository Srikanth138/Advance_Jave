//	Deductions:-
//	PT -> 15000/100=150
//	PF -> 15000/12.5=>1200
	
//	Earnings:-
//	BasicPay -> 6000
//	DA -> 4000
//	HRA -> 4000

//	BasicPay +DA (or) BasicPay +HRA=10000
//	GrossTotal -> 10000
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.nt.beans.PayBean;
import com.nt.db.DBConnection;

public class PayDAO {
	private static final String insert_Query="INSERT INTO public.\"PAY_DETAILS \"(Name\", \"noOfDays\", pan, \"basicPay\", \"Da\", \"Hra\", \"grossTotal\", \"Pf\", \"Pt\", \"NetSalary\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	
	int i;
	String pan="xxx";
	public int logic(HttpServletRequest req) {
		PayBean pb=new PayBean();
		Connection con=DBConnection.getCon();
		
		String name=req.getParameter("name");
		pb.setName(name);
		
		int salary=Integer.parseInt(req.getParameter("salary")); 
		 int pt=salary/100;
		 pb.setPT(pt);
		 int pf=(int) (salary/12.5);
		 pb.setPF(pf);
		 
		 int basicPay=Integer.parseInt(req.getParameter("basicPay"));
		 pb.setBasicPay(basicPay);
		 
		 int da=Integer.parseInt(req.getParameter("da"));
		  pb.setDA(da);
		  pb.setHRA(da);
		 
		  int grossTotal=basicPay+da;
		  pb.setGrossTotal(grossTotal);
		 
		  int day=Integer.parseInt(req.getParameter("day"));
		pb.setNoOfDay(day);
		
		try {
			PreparedStatement ps = con.prepareStatement(insert_Query);

			if (ps != null) {
				
				ps.setString(1, pb.getName());
				ps.setInt(2, pb.getNoOfDay());
				ps.setString(3, pan);
				ps.setInt(4, pb.getBasicPay());
				ps.setInt(5, pb.getDA());
				ps.setInt(6, pb.getHRA());
				ps.setInt(7,pb.getGrossTotal());
				ps.setInt(8,pb.getPF());
				ps.setInt(9,pb.getPT());
				ps.setInt(10,pb.getNetSalary());

				i = ps.executeUpdate();
			}//if

		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		
		return i;

	}// method

}// class
