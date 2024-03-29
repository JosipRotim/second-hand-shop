package com.cardealership.springmvc.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cardealership.springmvc.model.InputProduct;
import com.cardealership.springmvc.model.Product;
import com.cardealership.springmvc.model.Supplier;
import com.cardealership.springmvc.service.InputProductService;
import com.cardealership.springmvc.service.ItemService;
import com.cardealership.springmvc.service.ProductService;
import com.cardealership.springmvc.service.SupplierService;
import com.cardealership.springmvc.service.SupplierServiceImpl;

@Controller
public class ItemController {//Serves Data.

    @Autowired
    ItemService itemService;  //Service which will do all data retrieval/manipulation work
   
    @Autowired
    SupplierService supplierService;
    
    @Autowired
    InputProductService inputProductService;
    
    @Autowired
    ProductService productService;
    
	@RequestMapping("/categories")
    public ResponseEntity<List> listAllCategories() {
		System.out.println("*************************************ListAllItems");
    	List<String> categories = 	itemService.populateAllCategories();
        if(categories.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(categories, HttpStatus.OK);
    }
	
	@RequestMapping(value="/item/Phones")
    public ResponseEntity<List> listAllPhones() {
		System.out.println("*************************************ListAllPhones");
    	List items = 	itemService.findItemsByCategory("phones");
        if(items.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(items, HttpStatus.OK);
    }

	@RequestMapping(value="/item/Phones/{id}")
    public ResponseEntity<Object> findSpecificPhone(@PathVariable("id") long id) {
		System.out.println("*************************************findSpecificPhone");
    	Object item = 	itemService.findItemById(id, "phones");
        if(item == null){
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }

	@RequestMapping(value="/item/Printers")
    public ResponseEntity<List> listAllPrinters() {
		System.out.println("*************************************ListAllPrinters");
    	List items = 	itemService.findItemsByCategory("printers");
        if(items.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(items, HttpStatus.OK);
    }

	@RequestMapping(value="/item/Printers/{id}")
    public ResponseEntity<Object> findSpecificPrinter(@PathVariable("id") long id) {
		System.out.println("*************************************findSpecificPrinter");
    	Object item = 	itemService.findItemById(id, "printers");
        if(item == null){
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Object>(item, HttpStatus.OK);
    }
	
	@RequestMapping(value="/item/Suppliers")
    public ResponseEntity<List> listAllSuppliers() {
		System.out.println("*************************************ListAllSuppliers");
    	List suppliers = 	supplierService.findAllSuppliers();
        if(suppliers.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(suppliers, HttpStatus.OK);
    }
	
	
	@RequestMapping(value="/item/Suppliers/{id}")
    public ResponseEntity<List> findInputProduct(@PathVariable("id") int id) {
		System.out.println("*************************************findSpecificInputProduct");
    	List<InputProduct> inputProducts = inputProductService.findBySupplierId(id);
        if(inputProducts == null){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(inputProducts, HttpStatus.OK);
        
    } 
	
	@RequestMapping(value="/item/InputProduct/{id}")
    public ResponseEntity<List> findInputProductDetails(@PathVariable("id") int id) {
		//System.out.println("*************************************findSpecificInputProductDetails");
    	List<Product> Products = productService.findProductsByInputProductId(id);
    	System.out.println("*************************************findSpecificInputProductDetails " + Products);
        if(Products == null){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(Products, HttpStatus.OK);
        
    } 

}
