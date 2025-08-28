package com.example.hexapp.application.mappers;

import com.example.hexapp.application.dto.PriceDTO;
import com.example.hexapp.domain.vo.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-28T14:31:51+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class PriceApplicationMapperImpl implements PriceApplicationMapper {

    @Override
    public Price toVO(PriceDTO priceDTO) {
        if ( priceDTO == null ) {
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

        brandId = priceDTO.getBrandId();
        startDate = priceDTO.getStartDate();
        endDate = priceDTO.getEndDate();
        priceList = priceDTO.getPriceList();
        productId = priceDTO.getProductId();
        priority = priceDTO.getPriority();
        price = priceDTO.getPrice();
        curr = priceDTO.getCurr();

        Price price1 = new Price( brandId, startDate, endDate, priceList, productId, priority, price, curr );

        return price1;
    }

    @Override
    public PriceDTO toDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDTO.PriceDTOBuilder priceDTO = PriceDTO.builder();

        priceDTO.brandId( price.getBrandId() );
        priceDTO.startDate( price.getStartDate() );
        priceDTO.endDate( price.getEndDate() );
        priceDTO.priceList( price.getPriceList() );
        priceDTO.productId( price.getProductId() );
        priceDTO.priority( price.getPriority() );
        priceDTO.price( price.getPrice() );
        priceDTO.curr( price.getCurr() );

        return priceDTO.build();
    }
}
