package demo.spring.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

public class XServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(XServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		try {
			String uri = req.getRequestURI();
			String msg = String.format("你访问的是%s", uri);
			pw.write(msg);
			log.debug(msg);
		} finally {
			pw.close();
		}
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	

}
