package com.compassouol.desafiojavaspringboot.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.compassouol.desafiojavaspringboot.model.dao.IProductDAO;
import com.compassouol.desafiojavaspringboot.model.entity.impl.Product;

@Repository
public class ProductDAO extends GenericDAO<String, Product> implements IProductDAO {

	public ProductDAO() {
		super(Product.class);
	}
	@Override
	public List<Product> buscaComParametros(String q, Double minPrice, Double maxPrice) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> e = cq.from(Product.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (minPrice != null) {
			predicates.add(cb.greaterThanOrEqualTo(e.get("price"), minPrice));
		}
		if (maxPrice != null) {
			predicates.add(cb.lessThanOrEqualTo(e.get("price"), maxPrice));
		}
		if (q != null) {
			Predicate predicateName = cb.like(e.get("name"), "%" + q + "%");
			Predicate predicateDescription = cb.like(e.get("description"), "%" + q + "%");

			predicates.add(cb.or(predicateName,predicateDescription));
		}

		if (!predicates.isEmpty())
			cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

		List<Product> products = entityManager.createQuery(cq).getResultList();

		return products;
	}

}
