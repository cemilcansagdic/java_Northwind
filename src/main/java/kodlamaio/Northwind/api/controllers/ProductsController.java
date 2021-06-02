package kodlamaio.Northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Northwind.business.abstracts.ProductService;
import kodlamaio.Northwind.core.utilities.results.DataResult;
import kodlamaio.Northwind.core.utilities.results.Result;
import kodlamaio.Northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService; 
	}

	
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll()
	{
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}
}
