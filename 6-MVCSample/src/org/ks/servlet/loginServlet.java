package org.ks.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ks.Dao.loginDao;
import org.ks.entity.loginInformation;

//�������㣺���ڽ���view�����󣬷ַ���model�㴦��
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����¼
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		loginInformation logininfo = new loginInformation(name,pwd);    //���ӱ��õ���   uname ��  upwd ��װ��   JavaBean
		
		//����ģ�Ͳ��loginDao,����װ���û���������� logininfo(javaBean) ����login()����У�飬 �ٽ��ܴ�ģ�Ͳ㴫�صķ���ֵ
		int result = loginDao.login(logininfo);
		if(result > 0) {//��¼�ɹ�
			response.sendRedirect("welcome.jsp");
		}else {       //��¼ʧ�ܣ��������µ�¼
			response.sendRedirect("login.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
