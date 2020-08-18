package org.cassano.showroom.services;

import java.util.List;

import org.cassano.showroom.hibernate.DAO.BrandsDAO;
import org.cassano.showroom.hibernate.entities.BrandEntity;

public class BrandsService {
	
	BrandsDAO DAO = new BrandsDAO();

	public List<BrandEntity> getBrands() {
		List<BrandEntity> listE = DAO.getBrands();
		return listE;
	}

	public void addBrand(BrandEntity brand) {
		DAO.addBrand(brand);
	}

	public void updateBrand(BrandEntity updatedBrand) {
	    DAO.updateBrand(updatedBrand);
	}

	public void deleteBrand(int brandId) {
		DAO.deleteBrand(brandId);
	}

}
