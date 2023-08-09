package liveasy.assesment.service.serviceimplementation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liveasy.assesment.entity.Load;
import liveasy.assesment.exception.BodyEmptyException;
import liveasy.assesment.exception.LoadNotFound;
import liveasy.assesment.repository.LoadRepository;
import liveasy.assesment.service.LoadService;
@Service
public class LoadServiceImpl implements LoadService {
	
	@Autowired
	LoadRepository repo;

	@Override
	public void addLoad(Load load) {
		// TODO Auto-generated method stub
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date(); 
		    load.setDate(date);
		repo.save(load);
		
	}

	@Override
	public List<Load> getAllLoads() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Load getLoad(int loadId) {
		// TODO Auto-generated method stub
		return repo.getById(loadId);
	}

	@Override
	public void updateLoad(int loadId, Load load) throws LoadNotFound {
		// TODO Auto-generated method stub
		
		
		Load l=repo.getById(loadId);
		if(l==null)
		{
			throw new LoadNotFound("Load id doesnt Exsist");
		}
		
		l.setComment(load.getComment());
		l.setLoadingPoint(load.getLoadingPoint());
		l.setNoOfTrucks(load.getNoOfTrucks());
		l.setProductType(load.getProductType());
		l.setTruckType(load.getTruckType());
		l.setUnloadingPoint(load.getUnloadingPoint());
		l.setWeight(load.getWeight());
		l.setShipperId(load.getShipperId());
		
		repo.save(l);
		
	}

	@Override
	public void deleteLoad(int loadId) {
		// TODO Auto-generated method stub
		repo.deleteById(loadId);
	}

	@Override
	public Load getByShipperIdLoad(String shipperId) {
		// TODO Auto-generated method stub
		return repo.getLoadBYShiiperId(shipperId);
	}

}
