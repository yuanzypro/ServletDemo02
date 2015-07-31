package orz.yy.cookie;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CookieDemo01
 */
public class AddCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建cookie
		Cookie c1 = new Cookie("uname", "zhangsan");
		Cookie c2 = new Cookie("city", "beijing");
		
		//运用response发送cookie到客户端
		response.addCookie(c1);
		response.addCookie(c2);
		out.close();
	}

}
