package org.dcl.merchantproductapp.servlet;
import java.io.IOException;import javax.servlet.ServletException;import javax.servlet.annotation.WebServlet;import javax.servlet.http.*;
@WebServlet("/dashboard") public class DashboardServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{HttpSession s=req.getSession(false);if(s==null||s.getAttribute("merchantId")==null){resp.sendRedirect(req.getContextPath()+"/login.jsp");return;}req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);}
}
