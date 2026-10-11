package org.dcl.merchantproductapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.dcl.merchantproductapp.dto.Merchant;

public class MerchantDao {
	EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
	EntityManager man = fac.createEntityManager();

	public Merchant saveMerchant(Merchant m) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		man.persist(m);
		tran.commit();
		return m;
	}

	
	public Merchant updateMerchant(Merchant m) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		Merchant mdb = man.find(Merchant.class, m.getId());
		if(mdb != null) {
			mdb.setName(m.getName());
			mdb.setPhone(m.getPhone());
			mdb.setGst_num(m.getGst_num());
			mdb.setEmail(m.getEmail());
			mdb.setPassword(m.getPassword());
			tran.commit();
			return mdb;
		}
		else {
			return null;
		}
		
		
	}
	

	public Merchant findMerchantById(int mid) {
		return man.find(Merchant.class, mid);
	}


	public Merchant verifyMerchantByEmailAndPasswsord(String mail, String pass) {
			Query q= man.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
			q.setParameter(1, mail);
			q.setParameter(2, pass);
			
			try {
				Merchant m = (Merchant) q.getSingleResult();
				return m;
			} catch (Exception e) {
				return null;
			}
		
		
	}


	public Merchant verifyMerchantByPhoneAndPasswsord(long ph, String pass) {
		Query q= man.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, ph);
		q.setParameter(2, pass);
		
		try {
			Merchant m = (Merchant) q.getSingleResult();
			return m;
		} catch (Exception e) {
			return null;
		}
	}


	
}
