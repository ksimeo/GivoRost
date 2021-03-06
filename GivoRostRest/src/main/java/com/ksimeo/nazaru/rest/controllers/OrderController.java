package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.rest.services.OrderService;
import com.ksimeo.nazaru.core.models.Order;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by @Ksimeo on 26.01.2015
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "addneworder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public void addNewOrder(@RequestBody Order order) throws IOException {

        orderService.addNewOrder(order);

    }

    @RequestMapping(value = "delorder/{id}", method = RequestMethod.GET)
    @ResponseBody
    private void delOrder(@PathVariable int id) throws IOException {

        orderService.deleteOrder(id);

    }

    @RequestMapping(value = "getorderspage/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<Order> getOrdersPage(@PathVariable int id) throws IOException {

        return orderService.getOrders(id);
    }

    @RequestMapping(value = "from/{from}/to/{to}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<Order> getOrdersGroup(@PathVariable int from, @PathVariable int to) throws IOException {

        return orderService.getPage(from, to);
    }

    @RequestMapping(value = "getorderscount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public long getOrderCount() throws IOException {

        return orderService.getCount();
    }

    @RequestMapping(value = "/getallorders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<Order> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        System.out.println(orders);
        return orders;
    }

    @RequestMapping(value = "/delorderbyid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void delOrderById(@PathVariable int id) {

        orderService.deleteOrder(id);
    }


}