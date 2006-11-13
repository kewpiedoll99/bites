package com.barclayadunn.product;

import com.barclayadunn.database.ProductManagerDao;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

public class ProductManager implements Serializable {

	private ProductManagerDao pmd;
	private List products;

	public void setProductManagerDao(ProductManagerDao pmd) {
	    this.pmd = pmd;
	}

//	public void setProducts(List p) {
//		products = p;
//	}

	public List getProducts() {
		products = pmd.getProductList();
		return products;
	}

	public void increasePrice(int pct) {
	    ListIterator li = products.listIterator();
	    while (li.hasNext()) {
	        Product p = (Product) li.next();
//	        double newPrice = p.getPrice().doubleValue() * (100 + pct)/100;
//	        p.setPrice(new Double(newPrice));
		    pmd.increasePrice(p, pct);
	    }
	}
}