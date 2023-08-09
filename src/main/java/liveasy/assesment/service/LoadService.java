package liveasy.assesment.service;

import java.util.List;

import org.springframework.stereotype.Component;

import liveasy.assesment.entity.Load;
import liveasy.assesment.exception.LoadNotFound;

@Component
public interface LoadService {

	
	void addLoad(Load load);
	List<Load> getAllLoads();
	Load getLoad(int loadId);
	void updateLoad(int loadId,Load load) throws LoadNotFound;
	void deleteLoad(int loadId);
	Load getByShipperIdLoad(String shipperId);
}
