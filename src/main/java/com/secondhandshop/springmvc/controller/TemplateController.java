package com.secondhandshop.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {//Serves Templates.

    @RequestMapping(value="/category")
    public String getMainTemplate() {
    	return "template/all_categories";	
    }

    @RequestMapping(value="/category/Phones")
    public String getPhonesTemplate() {
    	return "template/category_phones";	
    }

    @RequestMapping(value="/category/Printers")
    public String getPrintersTemplate() {
    	return "template/category_printers";	
    }
    
    @RequestMapping(value="/category/Suppliers")
    public String getSuppliersTemplate() {
    	return "template/category_suppliers";	
    }

    @RequestMapping(value="/category/Phones/{id}")
    public String getPhonesDetailTemplate(@PathVariable("id") long id) {
    	return "template/category_phones_detail";	
    }

    @RequestMapping(value="/category/Printers/{id}")
    public String getPrintersDetailTemplate(@PathVariable("id") long id) {
    	return "template/category_printers_detail";	
    }
    
    @RequestMapping(value="/category/Suppliers/{id}")
    public String getSupplierDetailTemplate(@PathVariable("id") int id) {
    	return "template/category_suppliers_detail";	
    }
    
    @RequestMapping(value="/editForm")
    public String getFormDetailTemplate() {
    	return "template/editForm";	
    }
    
    @RequestMapping(value="/category/InputProduct/{id}")
    public String getProductsByInputProductIdTemplate(@PathVariable("id") int id) {
    	return "template/category_suppliers_detail";	
    }
    
    @RequestMapping(value="/inputProducts")
    public String getInputProductsTemplate() {
    	return "template/inputproducts";	
    }
    
    @RequestMapping(value="/products")
    public String getProductsTemplate() {
    	return "template/products";	
    }
    
    @RequestMapping(value="/pane")
    public String getPaneTemplate() {
    	return "template/pane";	
    }

}

