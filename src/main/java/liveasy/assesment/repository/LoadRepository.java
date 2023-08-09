package liveasy.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import liveasy.assesment.entity.Load;
@Repository
public interface LoadRepository extends JpaRepository<Load, Integer> {
	
	@Query("select l from load l where l.shipperId=?1")
	Load getLoadBYShiiperId(String shipperId);

}
