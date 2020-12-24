package com.hibernate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.dto.ProductDto;
import com.hibernate.service.ProductServiceImpl;
import com.hibernate.service.productService;


@WebServlet({"/controller" })
public class productServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	//for injecting service object class object in srvlet controller class
	//	when no state having better to keep in inti method
	private productService service;
	@Override
	public void init() throws ServletException {
		service= new ProductServiceImpl();	
	}
	//object gone injected to controller class


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int id=0;
		pw=res.getWriter();
		ProductDto dto=null;
		RequestDispatcher rd=null;
		//read from data
		id=Integer.parseInt(req.getParameter("pid"));
		//use service
		//for handling the exception better to keep int try catch block
		try {
			dto=service.fetchService(id);
			//if all got success so keep data int request scope so that we can use in jsp
			req.setAttribute("ptdo", dto);
			//forword data in jsp
			rd=req.getRequestDispatcher("/result.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			//if exception rise here so we can diplay in a page
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
			
		}
	}//doget

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
