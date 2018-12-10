package com.pg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pg.daos.pgDaos;
import com.pg.dtos.pgDtos;
import com.pg.dtos.pgrepDtos;

/**
 * Servlet implementation class PgController
 */
@WebServlet("/PgController.do")
public class PgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PgController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		pgDaos dao = new pgDaos();
		
		if(command.equals("boardlist2")) {
			List<pgDtos> list = dao.getAllBoard();
			request.setAttribute("list", list);
			RequestDispatcher dispatch = request.getRequestDispatcher("boardlist2.jsp");
			dispatch.forward(request, response);
			//dispatch("boardlist.jsp", request, response);
		}
		
		if(command.equals("insertform")) {
			
			RequestDispatcher dispatch = request.getRequestDispatcher("boardinsert.jsp");
			dispatch.forward(request, response);
			//dispatch("boardlist.jsp", request, response);
		}
		
	if(command.equals("boarddetail")) {
			String sseq = request.getParameter("seq");
			int seq = Integer.parseInt(sseq);
			pgDtos dto = dao.getBoard(seq);
			List<pgrepDtos> dto1 =  dao.getReply(seq);
			request.setAttribute("dto", dto);
			request.setAttribute("dto1", dto1);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("boarddetail.jsp");
			dispatch.forward(request, response);
			//dispatch("boardlist.jsp", request, response);
			
			
	if(command.equals("boardinsert")) {
		
		System.out.println("boardinsert 호출");
		String opvalue = request.getParameter("opvalue");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		System.out.println(opvalue + "" + id + "" + title + "" + content);

		try {
			boolean isS = dao.insertBoard(new pgDtos(opvalue,id,title,content));

			if(isS) {
				response.sendRedirect("PgController.do?command=boardlist2");

			}else {
				request.setAttribute("msg", "글 등록 실패입니다.");
			}
		} catch (SQLException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
			
			
			
			
		}
	}

}
}