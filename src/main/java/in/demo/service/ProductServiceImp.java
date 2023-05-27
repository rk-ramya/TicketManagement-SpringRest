package in.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.demo.dao.IProductDAO;
import in.demo.exception.ProductNotFoundException;
import in.demo.model.Products;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
	IProductDAO repo;
	
	@Override
	public void insertProducts(List<Products> product) {
		List<Products> pids = repo.saveAll(product);
		System.out.println("Product with below IDs inserted successfully!");
		for(Products i:pids)
			System.out.println(i.getId());
	}

	@Override
	public void removeProductsbyID(Integer id) {
		Optional<Products> findById = repo.findById(id);
		if(findById.isPresent()) {
			repo.deleteById(id);
			System.out.println("Deleted product with ID:"+id);
		}
		else
			throw new ProductNotFoundException("Product not found");
	}

	@Override
	public Products updateProducts(Products product) {
		Optional<Products> optional = repo.findById(product.getId());
		if(optional.isPresent()){	
			System.out.println("product with id "+ product.getId()+" updated");
			return repo.save(product);
		
		}
		else
			throw new ProductNotFoundException("Product not found");		
	}

	@Override
	public List<Products> DisplayProducts() {
		 return repo.findAll();
		
		
	}

}
