package org.concurrance.restaurant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.concurrance.restaurant.model.CookedDish;
import org.concurrance.restaurant.model.Dish;
import org.concurrance.restaurant.model.Menu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableAutoConfiguration
@Configuration
@PropertySource(value = { "classpath:config.json" }, factory=AppConfig.JsonLoader.class )
public class AppConfig  extends SpringBootServletInitializer {

	@Bean
	@Qualifier("queue")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public BlockingQueue<Dish> getQueue() {
		BlockingQueue<Dish> queue = new LinkedBlockingQueue<Dish>(10);
		return queue;
	}

	@Bean
	@Qualifier("cookedDishes")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public List<CookedDish> inizializeCookedDishes() {
		List<CookedDish> list = Collections.synchronizedList(new ArrayList<CookedDish>());
		return list;
	}
	
	@Bean
	@Qualifier("menu")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Menu inizializeMenu(Environment e) {
		//Loading menu
		ArrayList<Map> list = e.getProperty("menu", ArrayList.class);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Map entry : list) {
			map.put((String) entry.get("name"), (Integer) entry.get("cooking_time"));
		}
		Menu menu = new Menu();
		menu.setMenu(map);
		return menu;
	}
	
	@Bean
	@Qualifier("chefs")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Integer inizializeChefs(Environment e) {
		//Loading chefs
		return Integer.valueOf(e.getProperty("chefs"));
	}
	
	public static class JsonLoader implements PropertySourceFactory {
		public org.springframework.core.env.PropertySource<?> createPropertySource(String name,
				EncodedResource resource) throws IOException {
			Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);
            return new MapPropertySource("json-source", readValue);
		}
    }

}
