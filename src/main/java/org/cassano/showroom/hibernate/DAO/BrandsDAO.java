package org.cassano.showroom.hibernate.DAO;

import java.util.List;

import org.cassano.showroom.hibernate.entities.BrandEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BrandsDAO {
	
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(BrandEntity.class)
							.buildSessionFactory();

	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> listB = session.createQuery("from brands").getResultList();
		return listB;
	}

	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(BrandEntity updatedBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, updatedBrand.getBrandId());
		brand.setBrandName(updatedBrand.getBrandName());;
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();
	}

}
