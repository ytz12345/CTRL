package com.bupt.ctrl.dao;

import java.sql.*;

import com.bupt.ctrl.dao.IUserDao;
import com.bupt.ctrl.model.User;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/*进行数据库操作*/

@Repository("userDao")
public class UserDao implements IUserDao {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public User getUserByID(int user_id) {
        //按照uid从数据库中查找一个用户
        Session session = sessionFactory.getCurrentSession();
        //当getCurrentSession所在的方法，或者调用该方法的方法绑定了事务之后，session就与当前线程绑定了，也就能通过currentSession来获取，否则就不能。
        User user = session.get(User.class, user_id);

        return user;
    }

    public void saveUser(User user) {
        //向数据库中插入一个用户的方法
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    /*
    public User findUserByPwdAndID(User user) {
        //按照uid和pwd从数据库中查找一个用户，用于验证登录:用户是否存在,密码是否正确
        Session session = sessionFactory.getCurrentSession();
        User user0 = session.get(User.class, user.getUserId());
        return user0;
    }

    public void deleteByID(int user_id){

    }
    public void delete1(int user_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "delete from user_has_course where User_User_id=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            row = pstmt.executeUpdate();
            System.out.println("删除执行");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
    }
    public void delete2(int user_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "delete from user_has_chapter where User_User_id=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            row = pstmt.executeUpdate();
            System.out.println("删除执行");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
    }
    public void delete3(int user_id){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        con = DBConnection.getDBConnection();
        int row = 0;
        String sql = "delete from comment where User_User_id=?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            row = pstmt.executeUpdate();
            System.out.println("删除执行");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }
    }



    public boolean occupy(User user){
        Connection con=null;
        con = DBConnection.getDBConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from user where User_Name=?";
        System.out.println("///");
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getUser_Name());
            rs = pstmt.executeQuery();
            if (rs.next())
                return true;
            else
                return false;
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.closeDB(con, pstmt, rs);
        }

        return false;
    }
    */
}


