package com.rentcar.rentcar.controller;


import com.rentcar.rentcar.dao.*;
import com.rentcar.rentcar.domain.CarAdd;
import com.rentcar.rentcar.domain.OrderDetail;
import com.rentcar.rentcar.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Xing on 2015/11/24.
 */

@RestController
public class HomeController {

    @Autowired
    UserDao userDao;

    @Autowired
    CarDao carDao;

    @Autowired
    ShopDao shopDao;

    @Autowired
    FeedBackDao feedBackDao;

    @Autowired
    OrderDao orderDao;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<User> users = userDao.getUsers(keyWord);
        model.addAttribute("userCount", users.size());
        model.addAttribute("users", users);
        return "manager_user";
    }

    @RequestMapping("/manager_user")
    public String manager_user(Model model, @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {

        List<User> users = userDao.getUsers(keyWord);
        model.addAttribute("userCount", users.size());
        model.addAttribute("users", users);
        return "manager_user";
    }

    @RequestMapping("/manager_system")
    public String manager_system() {
        return "manager_system";
    }

    @RequestMapping("/manager_shop")
    public String manager_shop(Model model, @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<Shop> shops = shopDao.getShops(keyWord);
        model.addAttribute("shopCount", shops.size());
        model.addAttribute("shops", shops);
        return "manager_shop";
    }

    @RequestMapping("/manager_order")
    public String manager_order(Model model, @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<OrderDetail> orderDetails = orderDao.getOrders(keyWord);
        model.addAttribute("orderCount", orderDetails.size());
        model.addAttribute("orders", orderDetails);
        return "manager_order";
    }

    @RequestMapping("/manager_feedback")
    public String manager_feedback(Model model, @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
        List<FeedBack> feedBacks = feedBackDao.getFeedBacks(keyWord);
        model.addAttribute("feedBackCount", feedBacks.size());
        model.addAttribute("feedBacks", feedBacks);
        return "manager_feedback";
    }

    @RequestMapping("/manager_car")
    public String manager_car(Model model, @RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
//        List<Car> cars = carDao.getCars(keyWord);
//        model.addAttribute("carCount", cars.size());
//        model.addAttribute("cars", cars);
//        return "manager_car";
        return "fdfdf";
    }



    @RequestMapping(value = "/edit_shop", method = RequestMethod.GET)
    public String edit_shop(@RequestParam(value = "id", defaultValue = "") String id) {
       // Shop shop = shopDao.selectById(Integer.valueOf(id));
        //model.addAttribute("shop",shop);
        return "edit_shop";
    }

    @RequestMapping("/edit_order")
    public String edit_order(@RequestParam(value = "id", defaultValue = "") String id, Model model) {
        Order order = orderDao.selectById(Integer.valueOf(id));
        model.addAttribute("order",order);
        return "edit_order";
    }

    @RequestMapping("/edit_feedback")
    public String edit_feedback(@RequestParam(value = "id", defaultValue = "") String id, Model model) {
        FeedBack feedBack = feedBackDao.selectById(Integer.valueOf(id));
        model.addAttribute("feedback",feedBack);
        return "edit_feedback";
    }

    @RequestMapping("/edit_car")
    public String edit_car(@RequestParam(value = "id", defaultValue = "") String id, Model model) {
        CarAdd carAdd = carDao.selectById(Integer.valueOf(id));
        String isRental = carAdd.getIsRental();
        if ("1".equals(isRental)){
            carAdd.setIsRental("checked");
        }else {
            carAdd.setIsRental(null);
        }
        model.addAttribute("carAdd",carAdd);
        return "edit_car";
    }

    @RequestMapping("/add_shop")
    public String add_shop() {
        return "add_shop";
    }

    @RequestMapping("/add_car")
    public String add_car() {
        return "add_car";
    }

    @RequestMapping(value = "/addCar", method = {RequestMethod.POST})
    public String addCar(@ModelAttribute CarAdd carAdd, Model model) {
        Car car = new Car();
        car.setCarNumber(carAdd.getCarNumber());
        car.setCarType(carAdd.getCarType());
        car.setShopName(carAdd.getShopName());
        car.setCarStatus(carAdd.getCarStatus());
        car.setIsRentaling(carAdd.getIsRental() == null ? "0" : "1");
        car.setPrice(carAdd.getPrice());
        car.setType(carAdd.getCar_type());
        car.setMemo(carAdd.getMemo());
        boolean b = carDao.insertCar(car);
        List<Car> cars = carDao.getCars("");
        model.addAttribute("carCount", cars.size());
        model.addAttribute("cars", cars);
        model.addAttribute("success",b);
        return "manager_car";
    }

    @RequestMapping(value = "/addShop", method = {RequestMethod.POST})
    public String addShop(@ModelAttribute Shop shop, Model model){
        boolean insert = shopDao.insert(shop);
        List<Shop> shops = shopDao.getShops("");
        model.addAttribute("shopCount", shops.size());
        model.addAttribute("shops", shops);
        model.addAttribute("success",insert);
        return "manager_shop";
    }

    @RequestMapping("/delete_car")
    public String deleteCar(@RequestParam(value = "id", defaultValue = "") String id, Model model){
        carDao.deleteCar(id);
        List<Car> cars = carDao.getCars("");
        model.addAttribute("carCount", cars.size());
        model.addAttribute("cars", cars);
        return "manager_car";
    }

    @RequestMapping("/updateCar")
    public String updateCar(@ModelAttribute CarAdd carAdd, Model model){
        boolean b = carDao.updateCarAdd(carAdd);
        model.addAttribute("updateSuccess", b);
        List<Car> cars = carDao.getCars("");
        model.addAttribute("carCount", cars.size());
        model.addAttribute("cars", cars);
        return "manager_car";
    }

    @RequestMapping("/updateShop")
    public String updateShop(@ModelAttribute Shop shop, Model model){
        boolean b = shopDao.updateShop(shop);
        model.addAttribute("updateSuccess",b);
        List<Shop> shops = shopDao.getShops("");
        model.addAttribute("shopCount", shops.size());
        model.addAttribute("shops", shops);
        return "manager_shop";
    }

    @RequestMapping("/updatePassword")
         public String updatePassword(Model model, @RequestParam(name = "oldPassword") String oldPassword, @RequestParam(name = "newPassword") String newPassword){
        boolean b = userDao.updatePassword(oldPassword, newPassword);
        model.addAttribute("updateSuccess", b);
        return "manager_system";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(Model model, @RequestParam(name = "id") String id, @RequestParam(name = "orderStatus") String orderStatus){
        boolean b = orderDao.updateOrder(Integer.valueOf(id),orderStatus);
        model.addAttribute("updateSuccess", b);
        List<OrderDetail> orderDetails = orderDao.getOrders("");
        model.addAttribute("orderCount", orderDetails.size());
        model.addAttribute("orders", orderDetails);
        return "manager_order";
    }

}
