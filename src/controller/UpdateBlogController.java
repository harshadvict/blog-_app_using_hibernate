package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDAO;

import model.Blog;

@WebServlet(urlPatterns = {"/update"})
public class UpdateBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entering Update Blog");
		System.out.println("Entering do post");
		int blogId = Integer.parseInt(request.getParameter("blogId"));
		System.out.println(blogId);
		String blogTitle = request.getParameter("title");
		String blogDescription = request.getParameter("message");
		LocalDate postedOn = LocalDate.now();
		System.out.println(blogTitle);
		Blog blog = new Blog();
		blog.setBlogId(blogId);
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setPostedOn(postedOn);
		
		BlogDAO blogDao = new BlogDAO();
		try {
			blogDao.updateBlog(blog);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		/*
		 * RequestDispatcher rd=this.getServletContext().getRequestDispatcher(
		 * "/WEB-INF/views/blogView.jsp"); rd.forward(request, response);
		 */
	response.sendRedirect("allblogs");
	}

}
