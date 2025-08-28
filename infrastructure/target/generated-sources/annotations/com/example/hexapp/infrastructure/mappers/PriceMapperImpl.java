package com.example.hexapp.infrastructure.mappers;

import com.example.hexapp.domain.vo.Price;
import com.example.hexapp.infrastructure.persistence.entity.PriceEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-28T14:31:56+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public Price toVO(PriceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long brandId = null;
        LocalDateTime startDate = null;
        LocalDateTime endDate = null;
        Integer priceList = null;
        Long productId = null;
        Integer priority = null;
        BigDecimal price = null;
        String curr = null;

        brandId = entity.getBrandId();
        startDate = entity.getStartDate();
        endDate = entity.getEndDate();
        priceList = entity.getPriceList();
        productId = entity.getProductId();
        priority = entity.getPriority();
        price = entity.getPrice();
        curr = entity.getCurr();

        Price price1 = new Price( brandId, startDate, endDate, priceList, productId, priority, price, curr );

        return price1;
    }

    @Override
    public PriceEntity toEntity(Price domain) {
        if ( domain == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setBrandId( domain.getBrandId() );
        priceEntity.setStartDate( domain.getStartDate() );
        priceEntity.setEndDate( domain.getEndDate() );
        priceEntity.setPriceList( domain.getPriceList() );
        priceEntity.setProductId( domain.getProductId() );
        priceEntity.setPriority( domain.getPriority() );
        priceEntity.setPrice( domain.getPrice() );
        priceEntity.setCurr( domain.getCurr() );

        return priceEntity;
    }
}
