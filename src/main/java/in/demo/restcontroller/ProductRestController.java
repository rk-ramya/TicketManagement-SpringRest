package in.demo.restcontroller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.demo.model.Products;
import in.demo.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	IProductService service;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insertProducts(@RequestBody List<Products> product){
		try {
			service.insertProducts(product);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Exception occured",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProducts(@RequestBody Products product){
		try {
			return new ResponseEntity<Products>(service.updateProducts(product), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Exception occured",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/deleteID/{id}")
	public ResponseEntity<String> updateProducts(@PathVariable("id") Integer id){
		try {
			service.removeProductsbyID(id);
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Exception occured",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/displayAll")
	public ResponseEntity<?> displayProducts(){
		try {
			return new ResponseEntity<List<Products>>(service.DisplayProducts(),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Exception occured",HttpStatus.BAD_REQUEST);
		}
		
	}
}



