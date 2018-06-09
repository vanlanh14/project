package com.msita.training.controller;

import com.msita.training.entity.Order;
import com.msita.training.entity.OrderProduct;
import com.msita.training.entity.OrderProductKey;
import com.msita.training.entity.Product;
import com.msita.training.service.HomeService;
import com.msita.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    public String product(ModelMap model, HttpServletRequest request)
    {
        List<Product> products= (List<Product>) request.getSession().getAttribute("buyProduct");
        model.addAttribute("store",products);
        return "cart";
    }
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public String addProduct(@RequestParam("id") int id,
                             HttpServletRequest request) {
        String page= "cart";
        Product product = homeService.getProduct(id);
        List<Product> lst = (List<Product>) request.getSession().getAttribute("cart");
        boolean isExist = false;
        if(lst == null){
            lst =new ArrayList<>();
        }else{

            for(Product prod : lst){
                if(prod.getIdp().equals(id)){
                    prod.setQuantity(prod.getQuantity()+1);
                    isExist = true;
                }
            }
        }
        if(!isExist)
            lst.add(product);
        request.getSession().setAttribute("cart",lst);
        return "redirect:/"+page;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String deteProduct(@RequestParam("id") int id,
                             HttpServletRequest request) {
        String page = "cart";
        List<Product> lst = (List<Product>) request.getSession().getAttribute("cart");
        if(lst == null){
            lst =new ArrayList<>();
        }else{
            int prodPos = 0;
            for(Product prod : lst){
                if(prod.getIdp().equals(id)){
                    break;
                }
                prodPos+=1;
            }
            lst.remove(prodPos);
        }
        request.getSession().setAttribute("cart",lst);
        return "redirect:/"+page;
    }

    @RequestMapping(value = "/checkout",method = RequestMethod.GET)
    public String checkout(HttpServletRequest request){
        String page = "complete";
        List<Product> lst = (List<Product>) request.getSession().getAttribute("cart");
        if(lst == null){
            page ="home";
        }
        else {
            Order order =new Order();
            List<OrderProduct> lstOrderProduct = new ArrayList<>();
            int sum =0;
            for(Product prod :lst){
                sum+=(prod.getQuantity()*prod.getPrice());
                OrderProduct orderProduct = new OrderProduct();

                OrderProductKey key = new OrderProductKey();
                key.setIdo(order.getIdo());
                key.setIdp(prod.getIdp());
                orderProduct.setKey(key);

                orderProduct.setPrice(prod.getPrice());
                orderProduct.setQuantity(prod.getQuantity());
//                if(order.getLstOrderProduct()==null){
//                    order.setLstOrderProduct(new ArrayList<>());
//                    order.getLstOrderProduct().add(orderProduct);
//                }
                lstOrderProduct.add(orderProduct);
                String username = (String) request.getSession().getAttribute("username");
                order.setUsername(username);
                order.setSum(sum);
                orderService.saveOrder(order);
                for(OrderProduct orderProducts : lstOrderProduct){
                    orderProduct.getKey().setIdo(order.getIdo());
                    orderService.saveOrderProduct(orderProducts);
                }
            }
        }
        return "redirect:/"+page;
    }

}
