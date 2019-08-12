package dao.com.userdao;

import dao.studentdao.StudentBaseDao;
import entity.User;

import java.sql.*;

public class UserBaseDao {
    private static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/control_user?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";

    private static final String QUERY_SQL="SELECT username,password FROM tb_user WHERE username=?";

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
    public User query(String userName){
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;
        try {
            conn= getConnection();
            ps=conn.prepareStatement(QUERY_SQL);
            ps.setString(1,userName);
           rs = ps.executeQuery();
            //判断查询结果
            //查询得到
            while (rs.next()){

                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,ps,rs);
        }
        //查询不到
        return user;
    }
}
