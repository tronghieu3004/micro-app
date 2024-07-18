package dev.omega.microshopapp.repository;

import dev.omega.microshopapp.model.dto.OrderEntityDto;
import dev.omega.microshopapp.model.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByCode(String code);

    @Query("select concat('OC -',count(p),'-',to_char(now(),'YYYYMMDD-HH24MISS') ) " +
            "from OrderEntity p")
    String findNextCode();

    @Query("SELECT o.id as id, " +
            "o.fullName as name, " +
            "o.code as code," +
            "o.phone as phone, " +
            "sum (od.total) as totalCost " +
            "FROM OrderEntity o " +
            "JOIN OrderDetailEntity od ON o.id = od.order.id " +
            "WHERE (:keyword is null " +
            "or o.code ilike concat('%', :keyword, '%') " +
            "or o.fullName ilike concat('%', :keyword, '%')" +
            "or o.phone ilike concat('%', :keyword, '%') " +
            "or o.address ilike concat('%', :keyword, '%'))" +
            "AND (:code is null or o.code ilike concat('%', :code, '%')) " +
            "AND (cast(:createdAtFrom as date) is null or o.createdDate >= :createdAtFrom) " +
            "AND (cast(:createdAtTo as date) is null or o.createdDate <= :createdAtTo) " +
            "GROUP BY o.id " +
            "HAVING ((:totalCostFrom is null and :totalCostTo is null) " +
            "or (sum(od.total) between :totalCostFrom and :totalCostTo)) ")
    Page<OrderEntityDto.SearchRes> doSearch(String keyword,
                                            String code,
                                            Date createdAtFrom,
                                            Date createdAtTo,
                                            Double totalCostTo,
                                            Double totalCostFrom,
                                            Pageable pageable);

    @Query("SELECT new dev.omega.microshopapp.model.dto.OrderEntityDto.LightRes(" +
            "e.id, " +
            "e.fullName, " +
            "e.code, " +
            "sum(od.total)) " +
            "FROM OrderEntity e " +
            "JOIN OrderDetailEntity od ON e.id = od.order.id " +
            "ORDER BY e.id")
    List<OrderEntityDto.LightRes> findAllLightRes();
}
