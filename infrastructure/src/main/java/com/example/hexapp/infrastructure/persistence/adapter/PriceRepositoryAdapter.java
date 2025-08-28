package com.example.hexapp.infrastructure.persistence.adapter;

import com.example.hexapp.domain.repository.PriceRepository;
import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.domain.vo.PriceQuery;
import com.example.hexapp.infrastructure.mappers.PriceMapper;
import com.example.hexapp.infrastructure.persistence.entity.PriceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PriceRepositoryAdapter implements PriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private PriceMapper priceMapper;

    @Override
    public Optional<Price> findByBrandProductAndDate(PriceQuery priceQuery) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceEntity> criteriaQuery = criteriaBuilder.createQuery(PriceEntity.class);
        Root<PriceEntity> root = criteriaQuery.from(PriceEntity.class);

        Predicate byBrand = criteriaBuilder.equal(root.get("brandId"), priceQuery.getBrandId());
        Predicate byProduct = criteriaBuilder.equal(root.get("productId"), priceQuery.getProductId());

        Predicate afterStart = criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.literal(priceQuery.getApplicationDate()), root.get("startDate"));
        Predicate beforeEnd  = criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.literal(priceQuery.getApplicationDate()), root.get("endDate"));

        criteriaQuery.select(root).where(criteriaBuilder.and(byBrand, byProduct, afterStart, beforeEnd))
                .orderBy(criteriaBuilder.desc(root.get("priority")));

        List<PriceEntity> priceEntityList = entityManager.createQuery(criteriaQuery).setMaxResults(1).getResultList();

        return priceEntityList.stream().findFirst().map(priceMapper::toVO);
    }

    @Override
    public void save(Price price) {
        PriceEntity priceEntity = priceMapper.toEntity(price);
        entityManager.persist(priceEntity);
    }
}
