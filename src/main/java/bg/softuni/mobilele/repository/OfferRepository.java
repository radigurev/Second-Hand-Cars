package bg.softuni.mobilele.repository;

import bg.softuni.mobilele.model.entity.BrandEntity;
import bg.softuni.mobilele.model.entity.OfferEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferRepository extends
    JpaRepository<OfferEntity, UUID>,
    JpaSpecificationExecutor<OfferEntity> {

    @Query("select o from OfferEntity o where o.model.brand = :brandEntity")
    List<OfferEntity> getOffersByCar(@Param(value = "brandEntity")BrandEntity brandEntity);
}
