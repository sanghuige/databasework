package servlet;

import dao.com.userdao.UserDao;
import dao.studentdao.StudentDao;
import entity.User;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    /**
     * 登录页面跳转
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    /**
     * 用户验证
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userCheck(req, resp);
    }


    private void userCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        //判空
        try {
            if (StringUtils.isNotNull(username) && StringUtils.isNotNull(password)) {
                //查询用户
               UserDao ud = new UserDao();
                User user = ud.check(username);
                //判断用户账号密码是否正确
                if (user != null) {
                    //判断密码
                    if (password.equals(user.getPassword())) {
                        //密码正确跳转页面至student.jsp
                        req.getRequestDispatcher("/student").forward(req, resp);
                        return;
                    }
                }
            }
            out.println("<script type='text/javascript'>alert('用户名或密码错误');history.back();</script>");
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
