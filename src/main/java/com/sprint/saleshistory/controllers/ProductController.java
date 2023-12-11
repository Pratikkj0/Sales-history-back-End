package com.sprint.saleshistory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.saleshistory.models.ProductPojo;
import com.sprint.saleshistory.service.ProductService;

import jakarta.validation.Valid;

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

    // get collection of ProductPojos using given subCategory
    @GetMapping(value = "subcategory/{subcategory}")
    public ResponseEntity<List<ProductPojo>> getProductPojosBySubCategory(@PathVariable String subcategory) {
    	List<ProductPojo> productsBySubcategory = productService.getProductBySubcategory(subcategory);
        return new ResponseEntity<List<ProductPojo>>(productsBySubcategory, HttpStatus.OK);

    }

    // get collection of ProductPojos using given supplierId
    @GetMapping(value = "supplierid/{supplierid}")
    public ResponseEntity<List<ProductPojo>> getProductPojosBySupplierId(@PathVariable int supplierId) {
    	List<ProductPojo> productsBySupplierId = productService.getProductBySupplierId(supplierId);
        return new ResponseEntity<List<ProductPojo>>(productsBySupplierId, HttpStatus.OK);

    }

    // get collection of ProductPojos using given duplicates
    @GetMapping(value = "duplicates/{prodName}")
    public ResponseEntity<List<ProductPojo>> getProductPojosByDuplicates(@PathVariable String prodName) {
    	List<ProductPojo> duplicateProducts = productService.getDuplicateProducts(prodName);
        return new ResponseEntity<List<ProductPojo>>(duplicateProducts, HttpStatus.OK);
    }
    
    // get collection of ProductPojos using given status using request parameter
    // "status"
    @GetMapping(value = "/")
    public ResponseEntity<List<ProductPojo>> getListOfSoldProductPojosByStatus(@RequestParam(name = "status") String status) {
        // return ProductPojo collection
        return null;
    }

    // get collection of ProductPojos using given status using request parameter "field"
    @GetMapping("/field")
    public ResponseEntity<List<ProductPojo>> getListOfSoldProductPojosByField(@RequestParam(name = "field") String field) {
        // return ProductPojo collection
        return null;
    }

    // get collection of ProductPojos using given status using request parameter "field"
    @GetMapping(value = "/sort")
    public ResponseEntity<List<ProductPojo>> getProductPojosSortedByField(@RequestParam(name = "field") String field) {
        // return ProductPojo collection
        return null;
    }

}
