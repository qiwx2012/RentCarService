package com.rentcar.rentcar.dao;

import com.rentcar.rentcar.pojo.ManagerUser;
import com.rentcar.rentcar.pojo.ManagerUserExample;
import com.rentcar.rentcar.pojo.User;
import com.rentcar.rentcar.pojo.UserExample;
import com.rentcar.rentcar.service.ManagerUserMapper;
import com.rentcar.rentcar.service.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Xing on 2015/11/25.
 */


public interface UserDao {

    public List<User> getUsers(String keyWord);

    public boolean updatePassword(String oldPassword, String newPassword);
}
