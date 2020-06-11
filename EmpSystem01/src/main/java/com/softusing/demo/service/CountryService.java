package com.softusing.demo.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.softusing.demo.bean.Country;
import com.softusing.demo.mapper.CountryMapper;

@Service("countryService")
public class CountryService {
	@Resource
	private CountryMapper countryMapper;

	public List<Country> listCountry() {
		return countryMapper.listCountry();
	}
}
