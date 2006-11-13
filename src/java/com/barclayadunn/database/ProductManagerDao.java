package com.barclayadunn.database;

import java.util.List;
import com.barclayadunn.product.Product;

public interface ProductManagerDao {

    public List getProductList();

    public void increasePrice(Product prod, int pct);
}