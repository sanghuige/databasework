package servlet;

import dao.studentdao.StudentBaseDao;
import dao.studentdao.StudentDao;
import entity.Student;
import utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;




public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        search(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        transfer(req, resp);
    }





    private void transfer(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String type = req.getParameter("type");
        String jump=req.getParameter("jump");
        if (jump != null) {
            if ("ad".equals(jump)) {
              req.getRequestDispatcher("/stu_add.jsp").forward(req,resp);
               return;
            }
            if ("se".equals(jump)) {
                req.getRequestDispatcher("/stu_sec.jsp").forward(req,resp);
                return;
            }
            if ("de".equals(jump)) {
                req.getRequestDispatcher("/stu_del.jsp").forward(req,resp);
                return;
            }
        }
        //设置请求信息和响应信息的编码格式
        System.out.println("type:" + type);
        System.out.println("进来了");
//        req.setCharacterEncoding("utf-8");
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
        if (type != null) {
            if ("add".equals(type)) {
                add(req, resp);
            }
            if ("update".equals(type)) {
                upd(req, resp);
            }
            if ("search".equals(type)) {
                search(req, resp);
            }
            if ("del".equals(type)) {
                del(req, resp);
            }
        } else {
            search(req, resp);
        }
    }

    private void upd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String u2 = req.getParameter("update2");

        //判断从哪个界面进来
        if (!StringUtils.isNotNull(u2)) {
            //结果展示界面进来的
            String stuNo1 = req.getParameter("stuNo");
            System.out.println("学号1：" + stuNo1);
            String stuName1 = req.getParameter("stuName");
            System.out.println("姓名1：" + stuName1);
            String stuSex1 = req.getParameter("stuSex");
            System.out.println("性别1:" + stuSex1);
            String stuAge1 = req.getParameter("stuAge");
            System.out.println("年龄1：" + stuAge1);
            req.setAttribute("stuNo", stuNo1);
            req.setAttribute("stuName", stuName1);
            req.setAttribute("stuSex", stuSex1);
            req.setAttribute("stuAge", stuAge1);
            req.getRequestDispatcher("/stu_upd.jsp").forward(req, resp);
            return;
        }

        //从更新界面进来的
        //旧信息
        String oldNo = req.getParameter("oldNo");
        System.out.println("学号1：" + oldNo);
        String oldName = req.getParameter("oldName");
        System.out.println("姓名1：" + oldName);
        String oldSex = req.getParameter("oldSex");
        System.out.println("性别1:" + oldSex);
        String oldAge = req.getParameter("oldAge");
        System.out.println("年龄1：" + oldAge);

        //新信息
        String newNo = req.getParameter("newNo");
        System.out.println("学号2：" + newNo);
        String newName = req.getParameter("newName");
        System.out.println("姓名2：" + newName);
        String nwSex = req.getParameter("nwSex");
        System.out.println("性别2:" + nwSex);
        String newAge = req.getParameter("newAge");
        System.out.println("年龄2：" + newAge);


        System.out.println("1:"+!(oldNo.equals(newNo)));
        System.out.println("2:"+!(oldName.equals(newName)));
        System.out.println("3:"+!(oldAge.equals(newAge)));
        System.out.println("4:"+!(oldSex.equals(nwSex)));
        //设置更新信息
        Student stu = new Student();
        PrintWriter out = resp.getWriter();
        if (
                (newNo != null && newName != null && newAge != null && nwSex != null)
                    &&
                        (
                                ((!(oldNo.equals(newNo)) || !(oldName.equals(newName)))
                                ||
                                (!(oldAge.equals(newAge)) || !(oldSex.equals(nwSex))))
                        )
        ) {
//            //所有数据皆变换
//            if (!(oldNo.equals(newNo)) && !(oldName.equals(newName))) {
            out.println("<script type='text/javascript'> function c(){if(!confirm('确定更改数据?')) { history.back();return false;}}</script>");
            //验证学号是否需要修改
            if (StringUtils.isNotNull(newNo)) {
                stu.setStuNo(StringUtils.change(newNo, 0));
            } else {
                stu.setStuNo(StringUtils.change(oldNo, 0));
            }
            //验证名字是否需要修改
            if (!(oldName.equals(newName)) && StringUtils.isNotNull(newName)) {
                stu.setStuName(newName);
            } else {
                stu.setStuName(oldName);
            }
            //验证年龄是否需要修改
            if (!(oldAge.equals(newAge)) && StringUtils.isNotNull(newAge)) {
                stu.setStuAge(StringUtils.change(newAge, 0));
            } else {
                stu.setStuAge(StringUtils.change(oldAge, 0));
            }
            //验证性别是否需要修改
            if (!(oldSex.equals(nwSex)) && StringUtils.isNotNull(nwSex)) {
                stu.setStuSex(nwSex);
            } else {
                stu.setStuSex(oldSex);
            }
        }
        else {
//            页面数据没有更改
            out.println("<script type='text/javascript'>alert('您的数据没有变化，无需修改');history.back();</script>");
            return;
        }
        //修改数据
        StudentDao sd = new StudentDao();
        Integer row = sd.stuUpdate(stu, Integer.parseInt(oldNo));
        //根据结果进行判断
        if (row > 0) {
            //修改成功
            out.println("<script type='text/javascript'>alert('修改成功');location.href='/student';</script>");
        } else {
            //修改成功
            out.println("<script type='text/javascript'>alert('修改失败,该学号已存在');history.back();</script>");
        }

    }

    private void del(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stuAge = req.getParameter("stuAge");
        String stuName = req.getParameter("stuName");
        String stuSex = req.getParameter("stuSex");
        String stuNo = req.getParameter("stuNo");

        System.out.println("学号：" + stuNo);
        String errMsg = "";
        Integer row = 0;
        PrintWriter out = resp.getWriter();
        //判空
        //无数据传入
        try {
            if (!StringUtils.isNotNull(stuNo) && !StringUtils.isNotNull(stuAge) && !StringUtils.isNotNull(stuName) && !StringUtils.isNotNull(stuSex)) {
                throw new RuntimeException("请输入信息");
            }
            //有数据传入
            else {
                Student stu = new Student();
                if (StringUtils.isNotNull(stuNo)) stu.setStuNo(Integer.parseInt(stuNo));
                if (StringUtils.isNotNull(stuAge)) stu.setStuAge(Integer.parseInt(stuAge));
                if (StringUtils.isNotNull(stuName)) stu.setStuName(stuName);
                if (StringUtils.isNotNull(stuSex)) stu.setStuSex(stuSex);
                StudentDao sd = new StudentDao();
                row = sd.stu_del(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        //结果返回
        //删除成功
        if (row > 0) {
            out.println("<script type='text/javascript'>alert('删除成功');location.href='/student';</script>");
        }
        //删除失败
        else {
            //判断删除失败原因
            //无效数据
            if ("".equals(errMsg)) {
                out.println("<script type='text/javascript'>alert('数据库没有此项数据');history.back();</script>");
            }
            //没有数据传入
            else {
                out.println("<script type='text/javascript'>alert('删除失败:" + errMsg + "');history.back();</script>");
            }

        }
    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stuName = req.getParameter("stuName");
        String stuSex = req.getParameter("stuSex");
        String stuAge = req.getParameter("stuAge");
        //判空
        String errMsg = "";
        Integer result = -1;
        PrintWriter out = resp.getWriter();
        try {
            if (!StringUtils.isNotNull(stuName) && !StringUtils.isNotNull(stuAge)) {
                throw new RuntimeException("姓名及年龄不能为空");
            } else {
                Student stu = new Student();
                stu.setStuName(stuName);
                stu.setStuSex(stuSex);
                stu.setStuAge(StringUtils.change(stuAge, 0));
                StudentDao sd = new StudentDao();
                result = sd.stu_add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }

        if (result > 0) {
            out.println("<script type='text/javascript'>alert('增加成功');location.href='/student';</script>");
        } else {
            out.println("<script type='text/javascript'>alert('增加失败：" + errMsg + "');history.back();</script>");
        }

    }


    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息
        String stuAge = req.getParameter("stuAge");
        String stuName = req.getParameter("stuName");
        String stuSex = req.getParameter("stuSex");
        String stuNo = req.getParameter("stuNo");
        String all = req.getParameter("all");

        //针对响应信息进行处理
        PrintWriter out = resp.getWriter();
        String msg = "";
        List<Student> students = null;
        Student stu = null;
        try {
            if (!StringUtils.isNotNull(stuNo) && !StringUtils.isNotNull(stuName) && !StringUtils.isNotNull(stuAge) && !StringUtils.isNotNull(stuSex)) {
                if (StringUtils.isNotNull(all)) {
//                    System.out.println("all的值："+all);
                    throw new RuntimeException("请输入信息");
                } else {
                    stu = new Student();
                }
            } else {
                stu = new Student();
                if (!"".equals(stuNo)) stu.setStuNo(StringUtils.change(stuNo,0));
                if (!"".equals(stuAge)) stu.setStuAge(StringUtils.change(stuAge,0));
                if (!"".equals(stuName)) stu.setStuName(stuName);
                if (!"".equals(stuSex)) stu.setStuSex(stuSex);
            }
            StudentDao sd = new StudentDao();
            students = sd.stuFind(stu);
            boolean falg;
            if (students == null) {
                falg = true;
            } else {
                falg = false;
            }
            System.out.println("数组大小" + students.size());
            System.out.println("是否为null:" + falg);
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
        }

        if (students != null && students.size() > 0) {
            req.setAttribute("students", students);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } else {
            if (students.size() == 0) {
                out.println("<script type='text/javascript'>alert('数据库没有数据或没有该项数据，跳转数据添加页面');location.href='/transfer';</script>");
            } else {
                out.println("<script type='text/javascript'>alert('查询失败：" + msg + "');history.back();</script>");
            }
        }
    }

}


