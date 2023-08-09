package liveasy.assesment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import liveasy.assesment.entity.Load;
import liveasy.assesment.exception.LoadNotFound;
import liveasy.assesment.service.LoadService;

@RestController
public class LoadController {

	
	@Autowired
	LoadService ls;
	
	@PostMapping("/load")
	ResponseEntity<?> load(@RequestBody Load load){
		ls.addLoad(load);
		return new ResponseEntity("loads details added successfully ",HttpStatus.CREATED);
	}
	
	@GetMapping("/load")
    Load get(@RequestParam String shipperId) {
		return ls.getByShipperIdLoad(shipperId);
	}
	
	@GetMapping("/load/{loadId}")
	Load getLoad(@PathVariable int loadId)
	{
		return ls.getLoad(loadId);
	}
	
	@PutMapping("load/{loadId}")
	void update(@PathVariable int loadId,@RequestBody Load load) {
		try {
		ls.updateLoad(loadId, load);
		}
		catch (LoadNotFound e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	@DeleteMapping("/load/{loadId}")
	void delete(@PathVariable int loadId) {
		ls.deleteLoad(loadId);
	}
}
