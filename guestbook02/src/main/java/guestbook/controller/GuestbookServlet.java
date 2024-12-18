package guestbook.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import guestbook.dao.GuestbookDao;
import guestbook.vo.GuestbookVo;

@WebServlet("/gb") // {"/insert","add","/delete"}
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().print("<h1>ok</h1>");
		// String str = request.getRequestURI(); 한 다음 /를 split
		request.setCharacterEncoding("utf-8");
		
		String action=request.getParameter("a");
		if("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String contents = request.getParameter("contents");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(contents);
			
			GuestbookDao dao= new GuestbookDao();
			dao.insert(vo);
			
			response.sendRedirect("/guestbook02/gb");
		} else if("deleteform".equals(action)) {
			//String id = request.getParameter("id");
			//request.setAttribute(id, id);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response); // request 연장
		} else if("delete".equals(action)) {
			Long id = Long.parseLong(request.getParameter("id"));
			String password = request.getParameter("password");

			new GuestbookDao().deleteByIdAndPassword(id,password);
			
			response.sendRedirect("/guestbook02/gb");
		} else {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response); // request 연장
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
