package com.sprint.saleshistory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.models.ChannelWiseSoldCustomResponse;
import com.sprint.saleshistory.models.ProductPojo;
import com.sprint.saleshistory.service.ProductService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	ProductService productService;
    // get all ProductPojos
    @GetMapping
    public ResponseEntity<List<ProductPojo>> getAllProductPojos() {
    	List<ProductPojo> productPojos = productService.getAllProducts(); 
        return new ResponseEntity<List<ProductPojo>>(productPojos, HttpStatus.OK);
    }
    
    @GetMapping("{prodid}")
    public ResponseEntity<ProductPojo> getProductById(@PathVariable int prodid) {
    	ProductPojo product = productService.getProductByProdId(prodid);
        return new ResponseEntity<ProductPojo>(product, HttpStatus.OK);
    }
    // add new ProductPojo
    @PostMapping
    public ResponseEntity<String> addProductPojo(@Valid @RequestBody ProductPojo product) {
    	System.out.println("============================================");
        productService.addProduct(product);
        return new ResponseEntity<String>("Record Created Successfully", HttpStatus.OK);
    }

    // update new ProductPojo
    @PutMapping
    public ResponseEntity<String> updateProductPojo(@Valid @RequestBody ProductPojo product) {
    	productService.updateProduct(product);
        return new ResponseEntity<String>("Record Updated Successfully", HttpStatus.OK);
    }

    // delete a ProductPojo using given id
    @DeleteMapping(value = "{prodid}")
    public ResponseEntity<String> deleteProductPojo(@PathVariable int prodid) {
    	productService.deleteProduct(prodid);
        return new ResponseEntity<String>("Record Deleted Successfully", HttpStatus.OK);
    
    }

    // get collection of ProductPojos using given category
    @GetMapping(value = "category/{category}")
    public ResponseEntity<List<ProductPojo>> getProductPojosByCategory(@PathVariable String category) {
    	List<ProductPojo> productsByCategory = productService.getProductByCategory(category);
        return new ResponseEntity<List<ProductPojo>>(productsByCategory, HttpStatus.OK);
    
    }

    // get collection of ProductPojos using given status
    @GetMapping(value = "status/{status}")
    public ResponseEntity<List<ProductPojo>> getProductPojosByStatus(@PathVariable String status) {
    	List<ProductPojo> productsByStatus = productService.getProductByStatus(status);
        return new ResponseEntity<List<ProductPojo>>(productsByStatus, HttpStatus.OK);

    }
    
 // http://localhost:8080/api/v1/products/subcategory/{subcategory}
    @GetMapping("/subcategory/{subcategory}")
    public ResponseEntity<List<ProductPojo>> getProductsBySubcategory(@PathVariable String subcategory) {
        List<ProductPojo> products = productService.getProductsBySubcategory(subcategory);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

//   http://localhost:8080/api/v1/products/supplier/{supplierid}
    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<ProductPojo>> getProductsBySupplierId(@PathVariable int supplierId) {
        List<ProductPojo> products = productService.getProductsBySupplierId(supplierId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

 // http://localhost:8080/api/v1/products/duplicates
	@GetMapping("/duplicates")
	public ResponseEntity<List<ProductPojo>> findDuplicateProducts() {
		List<ProductPojo> duplicateProducts = productService.findDuplicateProducts();
		return new ResponseEntity<>(duplicateProducts, HttpStatus.OK);
	}

//	http://localhost:8080/api/v1/products/status?status=value
		@GetMapping("/status")
		public ResponseEntity<List<ProductPojo>> getProductByStatusValue(@RequestParam("status") String status) {
			List<ProductPojo> products = productService.getProductByStatus(status);
			return new ResponseEntity<>(products, HttpStatus.OK);
		}
	

   // http://localhost:8080/api/v1/products/sort?field=value
    @GetMapping("/sort")
    public ResponseEntity<List<ProductPojo>> findProductsOrderByField(@RequestParam("field") String field) {
        List<ProductPojo> products = productService.findProductsOrderByField(field);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
