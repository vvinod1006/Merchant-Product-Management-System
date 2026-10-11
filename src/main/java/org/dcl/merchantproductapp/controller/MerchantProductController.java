package org.dcl.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;

import org.dcl.merchantproductapp.dao.MerchantDao;
import org.dcl.merchantproductapp.dao.ProductDao;
import org.dcl.merchantproductapp.dto.Merchant;
import org.dcl.merchantproductapp.dto.Product;

public class MerchantProductController {
	static Scanner sc = new Scanner(System.in);
	static MerchantDao mdao = new MerchantDao();
	static ProductDao pdao = new ProductDao();
	public static void main(String[] args) {
		System.out.println("1.Save Merchant");
		System.out.println("2.Update Merchant");
		System.out.println("3.Find Merchant by ID");
		System.out.println("4.Verify Merchant by email_ID and password");
		System.out.println("5.Verfiy Merchant by phone and password");
		System.out.println("6.Add Product");
		System.out.println("7.Update Product");
		System.out.println("8.Find Products by Merchant id");
		System.out.println("9.Find Products by Brand");
		System.out.println("10.Find Products By Category");
		
		System.out.println("Enter the Choice");
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:saveMerchant();
				break;
		case 2:updateMerchant();
				break;
		case 3:findMerchantById();
				break;
		case 4:verifyMerchantByEmailAndPasswsord();
				break;
		case 5:verifyMerchantByPhoneAndPasswsord();
				break;
		case 6:addProduct();
				break;
		case 7:updateProduct();
				break;
		case 8:findProductsByMerchantId();
				break;
		case 9:findProductsByBrand();
				break;
		case 10:findProductsByCategory();
				break;
		default:System.err.println("Boss Open Your Eyes and see only 10 choices are there");
				break;
		}
		
}
	
	
	private static void findProductsByCategory() {
		
		System.out.println("Enter the Category to find Products");
		String br = sc.next();
		List<Product> lpdb=pdao.findProductsByCategory(br);
		if(lpdb.size()>0) {
			for(Product product :lpdb) {
				System.out.println(product);
			}
			
		}else {
			System.err.println("No Products Found");
		
		}
	}
	


	private static void findProductsByBrand() {
		System.out.println("Enter the Brand to find Products");
		String br = sc.next();
		List<Product> lpdb=pdao.findProductsByBrand(br);
		if(lpdb.size()>0) {
			for(Product product :lpdb) {
				System.out.println(product);
			}
			
		}else {
			System.err.println("No Products Found");
		
		}
	}


	private static void findProductsByMerchantId() {
		System.out.println("Enter the Merchant Id to find Products :");
		int mid =sc.nextInt();
		List<Product> lpdb=pdao.findProductsByMerchantId(mid);
		if(lpdb.size()>0) {
			for(Product product :lpdb) {
				System.out.println(product);
			}
			
		}else {
			System.err.println("No Products Found");
		}
	}


	private static void updateProduct() {
		System.out.println("Enter Product Information to Update");
		Product p = new Product();
		System.out.println("Enter Product id :");
		p.setId(sc.nextInt());
		System.out.println("Enter Product name");
		p.setName(sc.next());
		System.out.println("Enter Product Brand :");
		p.setBrand(sc.next());
		System.out.println("Enter Product Category");
		p.setCategory(sc.next());
		System.out.println("Enter Product Price");
		p.setPrice(sc.nextDouble());
//
		
		Product pdb = pdao.updateProduct(p);
		
		if(pdb !=null) {
			System.out.println("Product Information is updated");
		}else {
			System.err.println("Failed to update Product Information, try Again");
		}
		
	

	}


	private static void addProduct() {
		System.out.println("Enter Merchant ID :");
		int mid = sc.nextInt();
		
		Product p = new Product();
		
		System.out.println("Enter Product Information");
		System.out.println("Enter Product name");
		p.setName(sc.next());
		System.out.println("Enter Product Brand :");
		p.setBrand(sc.next());
		System.out.println("Enter Product Category");
		p.setCategory(sc.next());
		System.out.println("Enter Product Price");
		p.setPrice(sc.nextDouble());
//		p.setMerchant(null);
		
		
		Product pdb =pdao.addProduct(mid,p);
		if(pdb != null) {
			System.out.println("Product is Added with an ID :"+pdb.getId());
		}else {
			System.err.println("Unable to add the product since Merchant ID is Invalid");
		}
		
		
	}


	private static void verifyMerchantByPhoneAndPasswsord() {
			//we have to write code for this similar to verifyMerchantByEmailAndPasswsord
		System.out.println("Enter Phone :");
		long ph = sc.nextLong();
		System.out.println("Enter password :");
		String pass = sc.next();
		Merchant mdb = mdao.verifyMerchantByPhoneAndPasswsord(ph,pass);
		if(mdb!=null) {
			System.out.println("Merchant is Verified");
			System.out.println("Merchant Info is :"+mdb);
		}else {
			System.err.println("Merchant is not verified");
		}
	}


	private static void verifyMerchantByEmailAndPasswsord() {
			System.out.println("Enter email :");
			String mail = sc.next();
			System.out.println("Enter password :");
			String pass = sc.next();
			Merchant mdb = mdao.verifyMerchantByEmailAndPasswsord(mail,pass);
			if(mdb!=null) {
				System.out.println("Merchant is Verified");
				System.out.println("Merchant Info is :"+mdb);
			}else {
				System.err.println("Merchant is not verified");
			}
	}


	private static void findMerchantById() {
			System.out.println("Enter Merchant id :");
			int mid = sc.nextInt();
			Merchant mdb = mdao.findMerchantById(mid);
			if(mdb !=null) {
				System.out.println(mdb);
			}else {
				System.err.println("No Merchant Found");
			}
	}
	
	
	private static String updateMerchant() {
			System.out.println("Enter Merchant Information to Update");
			Merchant m = new Merchant();
			System.out.println("Enter Merchant id :");
			m.setId(sc.nextInt());
			System.out.println("Enter Merchant name :");
			m.setName(sc.next());
			System.out.println("Enter Merchant Phone Number :");
			m.setPhone(sc.nextLong());
			System.out.println("Enter GST Number :");
			m.setGst_num(sc.next());
			System.out.println("Enter Email ID :");
			m.setEmail(sc.next());
			System.out.println("Enter Password :");
			m.setPassword(sc.next());
			
			Merchant mdb = mdao.updateMerchant(m);
			
			if(mdb !=null) {
				System.out.println("Merchant Information is updated");
			}else {
				System.err.println("Failed to update Merchant Information, try Again");
			}
			
		
		return null;
	}
	
	private static void saveMerchant() {
		System.out.println("Enter the Merchant Information");
		Merchant m = new Merchant();
		System.out.println("Enter Merchant name :");
		m.setName(sc.next());
		System.out.println("Enter Merchant Phone Number :");
		m.setPhone(sc.nextLong());
		System.out.println("Enter GST Number :");
		m.setGst_num(sc.next());
		System.out.println("Enter Email ID :");
		m.setEmail(sc.next());
		System.out.println("Enter Password :");
		m.setPassword(sc.next());
		
		Merchant mdb = mdao.saveMerchant(m);
		System.out.println("Merchant Information is saved with an id :"+mdb.getId());
		
		
		
	}

}
