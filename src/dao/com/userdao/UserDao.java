package dao.com.userdao;

import entity.User;

public class UserDao extends UserBaseDao {

    public User check(String userName){
        return query(userName);
    }
}
