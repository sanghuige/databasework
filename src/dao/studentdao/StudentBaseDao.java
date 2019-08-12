package dao.studentdao;

import entity.Student;
import entity.User;
import utils.StringUtils;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.*;
import java.util.List;

public class StudentBaseDao {
    private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/homework?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";


    //启动驱动及连接服务器
    public Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER_CLASS);
             connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭流连接
    public void close(Connection conn, Statement st, ResultSet rs){
        try {
            if(rs!=null)rs.close();
            if(st!=null)st.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int  Update(String sql,List objects){
        Connection conn = null;
        PreparedStatement ps=null;

        try {
            conn =getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0;i<objects.size();i++){
                ps.setObject(i+1,objects.get(i));
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,ps,null);
        }
       return 0;
    }
}
