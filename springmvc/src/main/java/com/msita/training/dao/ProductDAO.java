package com.msita.training.dao;

import com.msita.training.entity.Product;
import com.msita.training.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDAO extends BaseDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Product> getProducts() {
//        List<Product> lst = getJdbcTemplateObject().query(
//                "SELECT * from product", new RowMapper<Product>() {
//                    @Override
//                    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
//                        Product product = new Product();
//                        product.setProductId(resultSet.getString("IdP"));
//                        product.setDescription(resultSet.getString("description"));
//                        product.setTitle(resultSet.getString("Title"));
//                        product.setImage(resultSet.getString("image"));
//                        product.setPrice(resultSet.getString("price"));
//                        return product;
//                    }
//                });

        return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();


    }
    @Transactional
    public Product findProduct(int id){
        return (Product) sessionFactory.getCurrentSession().get(com.msita.training.entity.Product.class, id);    }
}
