package orz.yy.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DecodeCookie
 */
public class DecodeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecodeCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie [] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				out.println("<h1>Name: " + name + "    Value:" 
						+ URLDecoder.decode(value,"UTF-8") + "</h1>");
			}
		} else {
			out.println("没有cookies信息。。。");
		}
		
		out.close();
	}

}
