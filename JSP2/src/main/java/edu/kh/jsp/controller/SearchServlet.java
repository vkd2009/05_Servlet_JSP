package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> nameList = new ArrayList<String>();
		
		nameList.add("김씨");
		nameList.add("최씨");
		nameList.add("이씨");
		nameList.add("백씨");
		nameList.add("손씨");
		nameList.add("우씨");
		nameList.add("박씨");
		
		
		// List에 입력 받은 이름(파라미터)가 존재하는지 확인
		String inputName = req.getParameter("inputName"); // 입력 받은 이름
		
		if( nameList.contains(inputName) ) { // 존재하는 경우 
//	  	 "OOO은 X번째 인덱스에 존재 합니다" 라는 메시지
//	  	 "/WEB-INF/views/practice/search_result.jsp"를 이용해서 출력
//	  	 (forward)
			
			String searchMessage 
				= String.format("%s은/는 %d번째 인덱스에 존재 합니다", 
										inputName, nameList.indexOf(inputName) );
			
			// forward 시 request가 유지된다!!
			req.setAttribute("searchMessage", searchMessage);
			
			String path = "/WEB-INF/views/practice/search_result.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} else { // 존재하지 않는 경우
			
//  	  "OOO은 존재하지 않습니다"  라는 메시지를
//  	  "/" 에 돌아와서(재요청) 출력
//  	  (redirect)
			
			String searchMessage = inputName + "은/는 존재하지 않습니다";
			
			HttpSession session = req.getSession(); // session 객체 얻어오기
			
			session.setAttribute("searchMessage", searchMessage);
			
			//  "/error" redirect
			resp.sendRedirect("/error"); // redirect는 무조건 GET 방식
		}
		
	
	}
	
	
}
