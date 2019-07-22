package com.cg.adif.dao.contable;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.adif.modal.contable.Contable;

@Repository
public interface ContableDb extends JpaRepository<Contable, Date>{
	
	//@Query("select c from Contable c where CONVERT(date, c.periodo_certificacion , 103) LIKE ':dd'")
	//@Query("select c from Contable c where DATEPART(dd, c.periodo_certificacion) = 01")
	
//	@Query("select c from Contable c where day(c.periodo_certificacion)=:dd or day(c.fecha_cierre)=:dd")
//	Page<Contable> customSearchBydd(@PathParam("dd") int dd,Pageable page);
//	
//	@Query("select c from Contable c where (day(c.periodo_certificacion)=:dd and month(c.periodo_certificacion)=:mm) or (day(c.fecha_cierre)=:dd and month(c.fecha_cierre)=:mm)")
//	Page<Contable> customSearchBymm(@PathParam("dd") int dd,@PathParam("mm") int mm,Pageable page);
//	
//	@Query("select c from Contable c where (day(c.periodo_certificacion)=:dd and month(c.periodo_certificacion)=:mm and year(c.periodo_certificacion)=:yy) or (day(c.fecha_cierre)=:dd and month(c.fecha_cierre)=:mm and year(c.fecha_cierre)=:yy) ")
//	Page<Contable> customSearchByy(@PathParam("dd") int dd,@PathParam("mm") int mm,@PathParam("yy") int yy,Pageable page);
//	
	@Query(value="select * from Contable m where m.periodo_certificacion LIKE '%'||?1||'%' or m.fecha_cierre LIKE '%'||?1||'%'",
			nativeQuery=true)
	Page<Contable> search(String date,Pageable page);

	
	
}
