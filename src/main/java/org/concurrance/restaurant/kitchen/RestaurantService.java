package org.concurrance.restaurant.kitchen;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.concurrance.restaurant.model.CookedDish;
import org.concurrance.restaurant.model.Dish;
import org.concurrance.restaurant.model.Info;
import org.concurrance.restaurant.model.Menu;
import org.concurrance.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
	
	@Autowired
	private Menu menu;
	
	@Autowired
	@Qualifier("queue")
	private BlockingQueue<Dish> queue;
	
	@Autowired
	@Qualifier("cookedDishes")
	private List<CookedDish> list;
	
	public Info receiveOrder(Order order) {
		Map<String, Integer> map = menu.getMenu();
		List<String> food = order.getFood();
		if( null != food && !food.isEmpty()) {
			for (String f : food) {
				if(map.containsKey(f)) {
					Dish dish = new Dish();
					dish.setName(f);
					dish.setCooking_time(map.get(f));
					dish.setTable(order.getTable());
					
					new java.lang.Thread(new Waiter(queue, dish)).start();
				} else {
					Info info = new Info("Dish " + f + " not in menu, please make another choise");
					return info;
				}
			}
		} else {
			Info info = new Info("empty order");
			return info;
		}
		
		Info info = new Info("order received");
		return info;
	}

	public List<CookedDish> showCookedDishes() {
		return list;
	}

}
