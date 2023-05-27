package in.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.demo.model.Products;

@Repository
public interface IProductDAO extends JpaRepository<Products, Integer> {

}
