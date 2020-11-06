package dao;

import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDaoInterface {
	
		void insertBlog(Blog blog) throws SQLException;
		Blog selectBlog(int blogid);
		List<Blog> selectAllBlogs();
		void deleteBlog(int id) throws SQLException;
		void updateBlog(Blog blog) throws SQLException, Exception;
	
}
