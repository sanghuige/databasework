package servlet;

import entity.Student;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/stu_add.jsp");
//        String stuNo = req.getParameter("stuNo");
//        System.out.println("转发的stuNo："+stuNo);
//        if (stuNo!=null){
//            req.setAttribute("stuNo",stuNo);
//            req.setAttribute("type","del");
//            req.getRequestDispatcher("/student").forward(req,resp);
//        }
    }
}
