package org.dcl.merchantproductapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.dcl.merchantproductapp.dto.Merchant;
import org.dcl.merchantproductapp.dto.Product;

public class ProductDao {
	
	EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
	EntityManager man = fac.createEntityManager();

	public Product addProduct(int mid, Product p) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		Merchant mdb=man.find(Merchant.class, mid);
		
		if(mdb!=null) {
			mdb.getProducts().add(p);
			p.setMerchant(mdb);
			man.persist(p);
			tran.commit();
			
			return p;
		}else {
			return null;
			
		}
		
		
	
	}

	public List<Product> findProductsByMerchantId(int mid) {
		Query q = man.createQuery("select m.products from Merchant m where m.id=?1");
		q.setParameter(1, mid);
		List<Product> lp = q.getResultList();
		return lp;
	}

	public List<Product> findProductsByBrand(String br) {
		Query q = man.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, br);
		List<Product> lp = q.getResultList();
		
		
		return lp;
		
	}

	public List<Product> findProductsByCategory(String br) {
		Query q = man.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, br);
		List<Product> lp = q.getResultList();
		
		
		return lp;
	}

	

	public Product updateProduct(Product p) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		Product pdb = man.find(Product.class, p.getId());
		if(pdb != null) {
			pdb.setName(p.getName());
			pdb.setBrand(p.getBrand());
			pdb.setCategory(p.getCategory());
			pdb.setPrice(p.getPrice());
			tran.commit();
			return pdb;
		}
		else {
			return null;
		}

	}

	

}
