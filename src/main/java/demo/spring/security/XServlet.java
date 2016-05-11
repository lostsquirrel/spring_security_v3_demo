package demo.spring.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import demo.spring.security.utils.SecurityUtils;

public class XServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(XServlet.class);
	
	private List<String> pages = new ArrayList<String>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		try {
			String uri = req.getRequestURI();
			String cp = req.getContextPath();
			String target = uri.substring(cp.length() + 1);
			String x = target.split("/")[0];
			String next = "/WEB-INF/pages/home.jsp";
			if (pages.contains(x)) {
				next = String.format("/WEB-INF/pages/%s.jsp", x);
			} else {
				String msg = String.format("你访问的是%s", uri);
				req.setAttribute("msg", msg);
				String username = SecurityUtils.getCurrentUsername();
				req.setAttribute("username", username);
				log.debug(msg);
			}
			req.getRequestDispatcher(next).forward(req, resp);;
		} finally {
			pw.close();
		}
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		pages.add("login");
		pages.add("home");
	}

	

}
