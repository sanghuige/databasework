package dao.studentdao;


import entity.Student;
import utils.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao extends StudentBaseDao {

public Integer stuUpdate(Student stu ,Object oldMsg){
    String sql="UPDATE  student SET sno=?,sname= ?,sex=? ,age=? WHERE sno=?";
    List objects= Arrays.asList(
          stu.getStuNo(), stu.getStuName(),stu.getStuSex(),stu.getStuAge()  ,oldMsg
    );
    return Update(sql,objects);
}

    public List<Student> stuFind(Student stu) {
        List<Student> list = new ArrayList<>();
        Connection conn = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer();
        sb.append("select * from student where  1=1 ");
        List listSet = new ArrayList();
        if (stu != null) {
            if (stu.getStuNo() > 0) {
                sb.append(" and sno= ? ");
                listSet.add(stu.getStuNo());
            }
            if(stu.getStuName()!=null){
                sb.append("and sname like ? ");
                listSet.add("%"+stu.getStuName()+"%");
            }
            if (stu.getStuSex() != null) {
                sb.append(" and sex = ? ");
                listSet.add(stu.getStuSex());
            }
            if (stu.getStuAge() > 0) {
                sb.append(" and age= ? ");
                listSet.add(stu.getStuAge());
            }
        }

            try {
                ps = conn.prepareStatement(sb.toString());
                if (listSet != null && listSet.size() > 0) {
                    for (int i = 0; i < listSet.size(); i++) {
                        ps.setObject(i + 1, listSet.get(i));
                    }
                }
//            ps.setString(1,(String)listSet.get(0));

                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setStuNo(rs.getInt("sno"));
                    student.setStuName(rs.getString("sname"));
                    student.setStuSex(rs.getString("sex"));
                    student.setStuAge(rs.getInt("age"));
                    list.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.close(conn, ps, rs);
            }
            return list;
        }

        public Integer stu_add(Student stu){
           String sql="INSERT INTO student(sname,sex,age) VALUES(?,?,?)";
           List objects= Arrays.asList(
                   stu.getStuName(),stu.getStuSex(),stu.getStuAge()
           );
            return Update(sql,objects);
        }

        public Integer stu_del(Student stu){
        String sql="DELETE FROM student WHERE 1=1";
        List listSet=new ArrayList();
            StringBuffer sb=new StringBuffer();
            sb.append(sql);
            if (stu != null) {
                if (stu.getStuNo() > 0) {
                    sb.append(" and sno= ? ");
                    listSet.add(stu.getStuNo());
                }
                if(stu.getStuName()!=null){
                    sb.append(" and sname = ? ");
                    listSet.add(stu.getStuName());
                }
                if (stu.getStuSex() != null) {
                    sb.append(" and sex = ? ");
                    listSet.add(stu.getStuSex());
                }
                if (stu.getStuAge() > 0) {
                    sb.append(" and age= ? ");
                    listSet.add(stu.getStuAge());
                }
            }

        return Update(sb.toString(),listSet);
        }


    }

