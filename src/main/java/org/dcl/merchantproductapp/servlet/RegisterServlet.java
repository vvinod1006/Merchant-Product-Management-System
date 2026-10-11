package org.dcl.merchantproductapp.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.dcl.merchantproductapp.dao.MerchantDao;
import org.dcl.merchantproductapp.dto.Merchant;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
 private MerchantDao dao; public void init(){dao=new MerchantDao();}
 protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  req.setCharacterEncoding("UTF-8"); String name=req.getParameter("name"),email=req.getParameter("email"),pass=req.getParameter("password"),phoneText=req.getParameter("phone"),gst=req.getParameter("gst_num");
  if(blank(name)||blank(email)||blank(pass)||blank(phoneText)||blank(gst)){req.setAttribute("error","Complete all fields.");req.getRequestDispatcher("/register.jsp").forward(req,resp);return;}
  try{long phone=Long.parseLong(phoneText); if(phoneText.length()!=10)throw new NumberFormatException(); Merchant m=new Merchant();m.setName(name.trim());m.setEmail(email.trim());m.setPassword(pass);m.setPhone(phone);m.setGst_num(gst.trim());dao.saveMerchant(m);resp.sendRedirect(req.getContextPath()+"/login.jsp?registered=1");}
  catch(NumberFormatException e){req.setAttribute("error","Enter a valid 10-digit phone number.");req.getRequestDispatcher("/register.jsp").forward(req,resp);}
  catch(Exception e){throw new ServletException("Registration failed. Check database settings and server log.",e);}
 }
 private boolean blank(String s){return s==null||s.trim().isEmpty();}
}
