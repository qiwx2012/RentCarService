package com.rentcar.rentcar.dao;

import com.rentcar.rentcar.domain.CarAdd;
import com.rentcar.rentcar.pojo.Car;
import com.rentcar.rentcar.pojo.CarExample;
import com.rentcar.rentcar.pojo.Shop;
import com.rentcar.rentcar.pojo.ShopExample;
import com.rentcar.rentcar.service.CarMapper;
import com.rentcar.rentcar.service.ShopMapper;
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
public interface CarDao {



    public List<Car> getCars(@Param("keyWord")String keyWord);

    public boolean insertCar(Car car);

    public void deleteCar(@Param("id")String id);

    public CarAdd selectById(@Param("id")Integer id);

    public boolean updateCarAdd(CarAdd carAdd) ;
}
