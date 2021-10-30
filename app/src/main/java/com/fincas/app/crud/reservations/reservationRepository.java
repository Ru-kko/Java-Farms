package com.fincas.app.crud.reservations;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface reservationRepository extends CrudRepository<reservationEntity,Long>{
    public List<reservationEntity> findByFarmAndClient(long farm, long client);

    @Query(value = "SELECT r.status, COUNT(r.status) FROM reservations AS r GROUP BY status", nativeQuery = true)
    public List<Object[]> getStatuscount();
}   