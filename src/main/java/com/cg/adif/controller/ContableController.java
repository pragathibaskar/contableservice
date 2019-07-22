package com.cg.adif.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.adif.modal.contable.Contable;
import com.cg.adif.modal.contable.SearchContableTo;
import com.cg.adif.service.contable.ContableService;

@RequestMapping("adif")
@RestController
public class ContableController {

	@Autowired
	private ContableService svc;
	
	 @PostMapping("/contables")
		ResponseEntity<Contable> create(@RequestBody Contable c)
		{
		 Contable con = svc.createNew(c);
		 if(con!=null)
			    return new ResponseEntity<>(c, HttpStatus.OK);
			else
			    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}
	 
	 @DeleteMapping("/contables/{ts}")
	   void deleteById(@PathVariable("ts") long ts)
	   {
		 Date date = new Date(ts);
         svc.deleteById(date);
	   }
	 
	 @PutMapping("/contables")
	 ResponseEntity<Contable> update(@RequestBody Contable c)
	  {
		 Contable con = svc.update(c);
		 if(con!=null)
			    return new ResponseEntity<>(c, HttpStatus.OK);
			else
			    return new ResponseEntity<>(null, HttpStatus.CONFLICT);
	  }
	 
	 @GetMapping("/contables/{page}/{size}")
	 Page<Contable> findUsingPagination(@PathVariable("page") int page,@PathVariable("size") int size)
	 {
		 Pageable listAll = null;
	     listAll = PageRequest.of(page, size);
		 return svc.findUsingPagination(listAll);
	 }
	
	 
	 @GetMapping("/contables/search")
	 Page<Contable> search(@RequestBody SearchContableTo search)
	 {
		 Pageable listAll = null;
	     listAll = PageRequest.of(search.getPage(), search.getSize());
		 return svc.search(search.getDate(), listAll);
		 
	 }
	 
	 
	
}
