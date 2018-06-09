package com.msita.training.dao;

import com.msita.training.entity.Order;
import com.msita.training.entity.OrderProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveOrder(Order order){
        Session session = this.sessionFactory.getCurrentSession();
        session.save(order);
    }
    @Transactional
    public void saveOrderProduct(OrderProduct orderProduct) {
        sessionFactory.getCurrentSession().save(orderProduct);
    }
}
