package cn.edu.xaut.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xaut.bean.StudentBean;
import cn.edu.xaut.dao.Studentdao;
import cn.edu.xaut.dao.Studentdaoin;

/**
 * Servlet implementation class showSearchStudent
 */
@WebServlet("/showSearchStudent")
public class showSearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showSearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String ss=request.getParameter("search");//ͨ���ֶε����ݵõ�����
		Studentdao s=new Studentdaoin();//ʵ����ʵ����Studentdao�Ľӿ�
		List<StudentBean> list=s.SearchStudent(ss);
		//System.out.println(ss);//�����Ӧ�������ֶ�
		request.setAttribute("studentlist", list);//��list���javabean��������setAttribute�����Ž�request����
			//����ת����manageҳ�棬jsp�յ�request��Ҳ�����յ�list���studentlistֵ
		request.getRequestDispatcher("manage.jsp").forward(request, response);
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}