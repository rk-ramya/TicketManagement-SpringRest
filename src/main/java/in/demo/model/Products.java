package in.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Product")
@Data
public class Products {
	@Id
	private Integer id;
	private String name;
	private Double price;
	@Column(name="itemsInStock")
	private Integer itemsInStock;

}
