package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ex3")
public class ExampleServlet3 extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		String pizza  = req.getParameter("pizza");
		String type   = req.getParameter("type");
		String orderName = req.getParameter("orderName");
		String address = req.getParameter("address");
		
		String [] options = req.getParameterValues("opt");
		
		System.out.println("확인");
		
		
		
		
		int price = 0;
		
		switch(pizza) {
			case "콤비네이션": price += 1000; break;
			case "불고기" 	 :
			case "포테이토"  :
			case "고구마"    : price += 2000; break;
			case "쉬림프"    : price += 4000; break;
		}
		
		switch(type) {
			case "오리지널" : price += 0; break;
			case "나폴리"   : price += 600; break;
			case "씬"       : price += 700; break;
		}
		
		if(options != null) {
			
			for(String opt : options) {
				switch(opt) {
					case "피클" 					: 
					case "핫소스" 				:
					case "갈릭디핑소스"   : price += 500; break;
					}
			}
			
		}	
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		
		
		sb.append("<head>");
		sb.append("     <title>");
		sb.append(String.format("%s 님 주문 영수증", orderName));
		sb.append("     </title>");
		sb.append("</head>");
	 	
		sb.append("<body>");
		sb.append(String.format("<h3>주문자명 : %s </h3>", orderName));
		sb.append(String.format("<h3>주소 : %s </h3>", address));
		
		sb.append("<ul>");
		
		sb.append(String.format("<li>도우 선택 : %s </li>" , type));
		
		if(options != null) { // 선택한 옵션이 있을 경우
			
				sb.append("<li>");
				sb.append("선택한 옵션 : ");
				for(String opt : options) sb.append(opt + " ");
				sb.append("</li>");
			}		
		sb.append("</ul>");
		
		sb.append(String.format("<h3>금액 : %d 원</h3>", price));
		
		
		sb.append("</body>");
		
		sb.append("</html>");
		
		out.print(sb.toString());
		
	}
	

	
	
	
	
}
