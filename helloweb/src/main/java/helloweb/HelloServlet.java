package helloweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String no = request.getParameter("no");
		
		System.out.println(id+":"+no);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 빈 개행도 보냄. 이제 body 내용 적기
		out.print("<h1>Hello "+id+"</h1>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); // doget과 dopost를 한번에 처리하도록 구성
	}

}
