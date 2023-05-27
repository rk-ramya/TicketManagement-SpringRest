package in.demo.service;

import java.util.List;

import in.demo.model.Products;

public interface IProductService {
	public void insertProducts(List<Products> product);
	public Products updateProducts(Products product);
	public List<Products> DisplayProducts();
	void removeProductsbyID(Integer id);
}
