package com.example.hexapp.infrastructure.persistence.adapter;

import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.domain.vo.PriceQuery;
import com.example.hexapp.infrastructure.mappers.PriceMapper;
import com.example.hexapp.infrastructure.persistence.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(com.example.hexapp.infrastructure.TestJpaConfig.class)
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "spring.sql.init.mode=never"
})
class PriceRepositoryAdapterTest {

    @Autowired
    private EntityManager entityManager;

    private final PriceMapper mapper = Mappers.getMapper(PriceMapper.class);

    @Test
    void findsTopByPriority() {
        PriceEntity priceEntity1 = new PriceEntity(null, 1L,
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-06-14T18:30:00"),
                1, 35455L, 0, new BigDecimal("35.50"), "EUR");
        PriceEntity priceEntity2 = new PriceEntity(null, 1L,
                LocalDateTime.parse("2020-06-14T15:00:00"),
                LocalDateTime.parse("2020-06-14T18:30:00"),
                2, 35455L, 1, new BigDecimal("25.45"), "EUR");
        entityManager.persist(priceEntity1);
        entityManager.persist(priceEntity2);
        entityManager.flush();

        PriceRepositoryAdapter adapter = new PriceRepositoryAdapter(entityManager, mapper);
        PriceQuery query = new PriceQuery(1L, 35455L, LocalDateTime.parse("2020-06-14T16:00:00"));

        Optional<Price> result = adapter.findByBrandProductAndDate(query);

        assertTrue(result.isPresent());
        assertEquals(2, result.get().getPriceList());
        assertEquals(new BigDecimal("25.45"), result.get().getPrice());
    }
}
