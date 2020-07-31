package com.neuedu.myoffice.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.myoffice.dao.StationMapper;
import com.neuedu.myoffice.entity.Station;
import com.neuedu.myoffice.service.StationService;

@Service
public class StationServiceImpl implements StationService {
	@Autowired
	private StationMapper stationMapper;

	@Override
	public Station selectById(String id) {
		if (id == null) {
			return null;
		}
		return stationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Station> selectAll() {
		return stationMapper.selectAll();
	}

	@Override
	public List<Station> findByCondition(String id, String name, String type) {
		if (id != "" && Integer.parseInt(id) < 1) {
			id = null;
	}
	if(name != null) {
		name = name.trim();
		if (name.length() == 0) {
			name = null;
		}
	}
	if(type != null) {
		type = type.trim();
		if (type.length() == 0) {
			type = null;
		}
	}
	return stationMapper.findByCondition(id, name, type);
	}

	@Override
	public boolean insert(Station station) {
		//业务逻辑验证
		//部门对象不能为空
		if (station == null) {
			return false;
		}
		//非空属性判断
		if (StringUtils.isAnyBlank(station.getName())||StringUtils.isBlank(station.getType())) {
			return false;
		}
		int line = stationMapper.insertSelective(station);
		if (line == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Station station) {
		int line = stationMapper.updateByPrimaryKeySelective(station);
		if (line == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean batchDelete(String[] ids) {
		if (ids == null||ids.length == 0) {
			return false;
		}
		for (String id : ids) {
			if (Integer.parseInt(id) <= 0) {
				return false;
			}
		}
		int line = stationMapper.batchDelete(ids);
		if(line > 0)
			return true;
		return false;
	}

}
