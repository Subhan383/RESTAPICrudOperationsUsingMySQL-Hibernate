package org.studyeasy.showroom.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.showroom.model.BrandEntity;
import org.studyeasy.showroom.model.ProductEntity;

public class ProductsDAO {
	
	SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(ProductEntity.class)
            .addAnnotatedClass(BrandEntity.class)
            .buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<ProductEntity> productlist;
		String query="from products where brandId = '"+brandId+"'";
		productlist=session.createQuery(query).getResultList();
		return productlist;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<ProductEntity> productlist;
		String query="from products where brandId='"+brandId+"' and category='"+category+"'";
		productlist=session.createQuery(query).getResultList();
		return productlist;
	}

}
