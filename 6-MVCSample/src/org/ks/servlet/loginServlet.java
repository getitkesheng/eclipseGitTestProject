package org.ks.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ks.Dao.loginDao;
import org.ks.entity.loginInformation;

//控制器层：用于接受view层请求，分发给model层处理
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理登录
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		loginInformation logininfo = new loginInformation(name,pwd);    //将从表单拿到的   uname 和  upwd 封装成   JavaBean
		
		//调用模型层的loginDao,将封装了用户名和密码的 logininfo(javaBean) 传给login()进行校验， 再接受从模型层传回的返回值
		int result = loginDao.login(logininfo);
		if(result > 0) {//登录成功
			response.sendRedirect("welcome.jsp");
		}else {       //登录失败，跳到重新登录
			response.sendRedirect("login.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
