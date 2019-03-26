package com.rentcar.rentcar.dao;

import com.rentcar.rentcar.domain.OrderDetail;
import com.rentcar.rentcar.pojo.*;
import com.rentcar.rentcar.service.CarMapper;
import com.rentcar.rentcar.service.OrderMapper;
import com.rentcar.rentcar.service.ShopMapper;
import com.rentcar.rentcar.service.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xing on 2015/11/25.
 */

public interface OrderDao {



    public List<OrderDetail> getOrders(String keyWord) ;

    public Order selectById(Integer integer) ;

    public boolean updateOrder(Integer integer, String orderStatus);
}
