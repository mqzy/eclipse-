package com.neuedu.myoffice.service;

import java.util.List;

import com.neuedu.myoffice.entity.Station;

public interface StationService {
	Station selectById(String id);
	List<Station> selectAll();
	List<Station> findByCondition(String id,String name,String type);
	boolean insert(Station station);
	boolean update(Station station);
	boolean batchDelete(String[] ids);
}
