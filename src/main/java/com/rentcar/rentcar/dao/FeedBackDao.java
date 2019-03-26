package com.rentcar.rentcar.dao;

import com.rentcar.rentcar.pojo.FeedBack;
import com.rentcar.rentcar.pojo.FeedBackExample;
import com.rentcar.rentcar.service.FeedBackMapper;
import org.apache.ibatis.annotations.Param;
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

public interface FeedBackDao {


    public List<FeedBack> getFeedBacks(@Param("keyWord")String keyWord);

    public FeedBack selectById(@Param("integer")Integer integer);
}
