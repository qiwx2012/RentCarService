/*
package com.rentcar.rentcar.service.impl;

import com.rentcar.rentcar.domain.CarRent;
import com.rentcar.rentcar.domain.CarWithShopName;
import com.rentcar.rentcar.pojo.*;
import com.rentcar.rentcar.service.*;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Xing on 2015/11/28.
 *//*

@RequestMapping("/mgr/car")
@RestController
@Transactional
public class CarServer extends BaseServer {

    @Override
    protected Logger getLogger() {
        return LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value = "/list",method = {RequestMethod.POST})
    public JsonResponse list(@ModelAttribute User user, @RequestParam(value = "id") int id){
        String page = String.valueOf((id-1)*10);
        JsonResponse json = new JsonResponse(false);
        if (validateUser(user.getPhoneName(),user.getPassword())){
            SqlSession session = openSession();
            CarMapper carMapper = session.getMapper(CarMapper.class);
            CarExample carExample = new CarExample();
            ShopMapper shopMapper = session.getMapper(ShopMapper.class);
            carExample.createCriteria().andIsRentalingEqualTo("0");
            carExample.setOrderByClause("id ASC LIMIT " + page + ",10");
            List<Car> cars = carMapper.selectByExample(carExample);
            if (cars != null && cars.size() > 0){
                List<CarWithShopName> carWithShopNames = new ArrayList<CarWithShopName>();
                for (Car car : cars){
                    CarWithShopName carWithShopName = new CarWithShopName();
                    carWithShopName.setCarNumber(car.getCarNumber());
                    carWithShopName.setMemo(car.getMemo());
                    carWithShopName.setShopName(car.getShopName());
                    carWithShopName.setCarStatus(car.getCarStatus());
                    carWithShopName.setCarType(car.getCarType());
                    carWithShopName.setId(car.getId());
                    carWithShopName.setIsRentaling(car.getIsRentaling());
                    carWithShopName.setPrice(car.getPrice());
                    carWithShopName.setShopId(car.getShopId());
                    carWithShopName.setType(car.getType());
                    Integer shopId = car.getShopId();
                    Shop shop = shopMapper.selectByPrimaryKey(shopId);
                    carWithShopName.setPosition(shop.getPosition());
                    carWithShopNames.add(carWithShopName);
                }
                json.put("cars",carWithShopNames);
                json.setSuccess(true);
            }else{
                json.setSuccess(false);
            }
        }else {
            json.setSuccess(false);
        }
        return json;
    }

    */
/**
     * 租车成功返回0
     * 租车失败返回-1
     * @param user
     * @param carRent
     * @return
     *//*

    @RequestMapping(value = "/rentCar",method = {RequestMethod.POST})
    public String rentCar(@ModelAttribute User user, @ModelAttribute CarRent carRent) throws ParseException {
        if (validateUser(user.getPhoneName(),user.getPassword())){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SqlSession session = openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            CarMapper carMapper = session.getMapper(CarMapper.class);
            ShopMapper shopMapper = session.getMapper(ShopMapper.class);
            OrderMapper orderMapper = session.getMapper(OrderMapper.class);
            UserExample userExample = new UserExample();
            CarExample carExample = new CarExample();
            ShopExample shopExample = new ShopExample();
            OrderExample orderExample = new OrderExample();

            //租车用户
            userExample.clear();
            userExample.createCriteria().andPhoneNameEqualTo(user.getPhoneName());
            User user1 = userMapper.selectByExample(userExample).get(0);

            //租的车
            Car car = null;
            shopExample.clear();
            Shop shop = shopMapper.selectByPrimaryKey(Integer.valueOf(carRent.getShopId()));
            carExample.clear();
            carExample.createCriteria().andCarTypeEqualTo(carRent.getCarType()).andIsRentalingEqualTo("0").andShopIdEqualTo(shop.getId());
            List<Car> cars = carMapper.selectByExample(carExample);
            if (cars != null && cars.size() > 0){
                car = cars.get(0);
                car.setIsRentaling("1");
                carMapper.updateByPrimaryKeySelective(car);
            }else {
                return "-1";
            }

            //生成订单
            Order order = new Order();
            order.setUserId(user1.getId());
            order.setOutTime(dateFormat.parse(carRent.getOutTime()));
            order.setBackTime(dateFormat.parse(carRent.getBackTime()));
            order.setIsFeedback(0);
            order.setOrderSatus("1");
            order.setMemo(carRent.getMemo());
            order.setOtherServer(carRent.getOtherServer());
            order.setType(car.getType());
            order.setCarId(car.getId());
            orderExample.clear();
            orderExample.setOrderByClause("id DESC");
            List<Order> orders = orderMapper.selectByExample(orderExample);
            if (orders != null && orders.size() > 0){
                Order order1 = orders.get(0);
                order.setOrderId(String.valueOf(order1.getId() + 1));
            }else {
                order.setOrderId("1");
            }
            orderMapper.insert(order);
            return "0";

        }else {
            return "-1";
        }
    }

    @RequestMapping(value = "/listCar",method = {RequestMethod.POST})
    public JsonResponse listCar(@ModelAttribute User user, @RequestParam(value = "type") String type, @RequestParam(value = "id") String id){
        JsonResponse json = new JsonResponse(false);
        if (validateUser(user.getPhoneName(),user.getPassword())){
            SqlSession session = openSession();
            CarMapper carMapper = session.getMapper(CarMapper.class);
            CarExample carExample = new CarExample();
            carExample.clear();
            carExample.createCriteria().andShopIdEqualTo(Integer.valueOf(id)).andIsRentalingEqualTo("0").andTypeEqualTo(type);
            List<Car> cars = carMapper.selectByExample(carExample);
            json.put("data",cars);
            json.setSuccess(true);
        }else {
            json.setSuccess(false);
        }
        return json;
    }

}
*/
