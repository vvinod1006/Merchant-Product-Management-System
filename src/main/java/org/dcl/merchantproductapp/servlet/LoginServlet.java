package org.dcl.merchantproductapp.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.dcl.merchantproductapp.dao.MerchantDao;
import org.dcl.merchantproductapp.dto.Merchant;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private MerchantDao dao;
  public void init(){ dao=new MerchantDao(); }
  protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
    req.setCharacterEncoding("UTF-8"); String email=req.getParameter("email"), pass=req.getParameter("password");
    if(email==null||pass==null||email.trim().isEmpty()||pass.isEmpty()){req.setAttribute("error","Enter email and password.");req.getRequestDispatcher("/login.jsp").forward(req,resp);return;}
    try { Merchant m=dao.verifyMerchantByEmailAndPasswsord(email.trim(),pass);
      if(m==null){req.setAttribute("error","Invalid email or password.");req.getRequestDispatcher("/login.jsp").forward(req,resp);return;}
      HttpSession old=req.getSession(false); if(old!=null) old.invalidate(); HttpSession s=req.getSession(true); s.setAttribute("merchantId",m.getId()); s.setAttribute("merchantName",m.getName());
      resp.sendRedirect(req.getContextPath()+"/dashboard");
    } catch(Exception e){throw new ServletException("Login failed. Check database settings and server log.",e);}
  }
  protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException{resp.sendRedirect(req.getContextPath()+"/login.jsp");}
}