package com.secondhandshop.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.secondhandshop.springmvc.model.Phone;
import com.secondhandshop.springmvc.model.Printer;
import com.secondhandshop.springmvc.model.State;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Phone> phones;
	
	private static List<Printer> printers;
	
	
	static{
		phones= populateDummyPhones();
		printers= populateDummyPrinters();
		
	}
	
	public List findItemsByCategory(String category) {

		if(StringUtils.equalsIgnoreCase(category, "phones")){
			return phones;
		} else if(StringUtils.equalsIgnoreCase(category, "printers")){
			return printers;
		}
		return phones;
	}

	public Object findItemById(long id, String category) {
		if(category.equalsIgnoreCase("phones")){
			for(Phone phone : phones){
				if(phone.getId() == id){
					return phone;
				}
			}
		} if(category.equalsIgnoreCase("printers")){
			for(Printer printer : printers){
				if(printer.getId() == id){
					return printer;
				}
			}
			
		}
		return null;
	}
	

	public List<String> populateAllCategories(){
		List<String> allCategories = new ArrayList<String>();
		allCategories.add("Phones");
		allCategories.add("Printers");
		allCategories.add("Suppliers");
		return allCategories;
	}

	private static List<Phone> populateDummyPhones(){
		List<Phone> phones = new ArrayList<Phone>();
		
		phones.add(new Phone(counter.incrementAndGet(),"Apple", "IPhone6s", State.NEW, 800, 5.2, false,false,15));
		phones.add(new Phone(counter.incrementAndGet(),"Huwawi", "Nexus6P", State.NEW, 700, 5.7, false,false,13));
		phones.add(new Phone(counter.incrementAndGet(),"Samsung", "Note5", State.NEW, 600, 5.7, false,false,14));
		phones.add(new Phone(counter.incrementAndGet(),"HTC", "M9", State.NEW, 580, 5.5, true,true,16));
		phones.add(new Phone(counter.incrementAndGet(),"LG", "G4", State.NEW, 550, 5.7, true,true,15));
		return phones;
	}


	private static List<Printer> populateDummyPrinters(){
		List<Printer> printers = new ArrayList<Printer>();
		
		printers.add(new Printer(counter.incrementAndGet(),"HP", "OfficeJet 7500A", State.NEW, 200, "A4", "InkJet",15));
		printers.add(new Printer(counter.incrementAndGet(),"Brother", "J6520dw", State.NEW, 180, "A4", "InkJet",12));
		printers.add(new Printer(counter.incrementAndGet(),"EPSON", "XP-820", State.NEW, 210, "A4", "InkJet",14));
		return printers;
	}

}
