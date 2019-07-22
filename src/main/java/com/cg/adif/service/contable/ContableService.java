package com.cg.adif.service.contable;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cg.adif.modal.contable.Contable;
import com.fasterxml.jackson.annotation.JsonFormat;

public interface ContableService {
	
	Contable createNew(Contable c);
	void deleteById(Date periodo_certificacion);
	Contable update(Contable c);
	Page<Contable> findUsingPagination(Pageable page);
	Page<Contable> search(String date,Pageable page);
//	Page<Contable> searchUsingDay(String dd,Pageable page);
//	Page<Contable> searchUsingMonth(String dd,String mm,Pageable page);
//	Page<Contable> searchUsingYear(String dd,String mm,String yyyy,Pageable page);
	

}
