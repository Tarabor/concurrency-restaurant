package org.concurrance.restaurant;

import java.util.List;

import org.concurrance.restaurant.kitchen.RestaurantService;
import org.concurrance.restaurant.model.CookedDish;
import org.concurrance.restaurant.model.Info;
import org.concurrance.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restaurant {
	
	@Autowired
	RestaurantService service;
    
    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public Info receiveOrder(@RequestBody Order order) {
    	Info info = service.receiveOrder(order);
    	return info;
    }
    
    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public List<CookedDish> showCookedDishes() {
    	List<CookedDish> list = service.showCookedDishes();
    	return list;
    }

}
