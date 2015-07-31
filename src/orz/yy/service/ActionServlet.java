package orz.yy.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String uri = request.getRequestURI();
		String action = 
				uri.substring(uri.lastIndexOf("/",uri.lastIndexOf(".")));
		
		if(action.equals("login")){
			String name = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			if(name.equals("111") && pwd.equals("111")){
				session.setAttribute("uname", name);
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("msg", "登录失败。。。");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
		
		out.close();
	}

}






