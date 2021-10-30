package com.fincas.app.crud.reservations;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface reservationRepository extends CrudRepository<reservationEntity,Long>{
    public List<reservationEntity> findByFarmAndClient(long farm, long client);

    public List<reservationEntity> findAllByStatus(String status);

    public List<reservationEntity> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    @Query ("SELECT COUNT(c.client) ,c.client FROM reservationEntity c WHERE c.status = 'completed' group by c.client ORDER by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservations();
}