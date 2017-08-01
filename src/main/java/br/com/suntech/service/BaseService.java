package br.com.suntech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

public abstract class BaseService {

	protected PageRequest getPageRequest(int page, int size, String... sortFields) {
		if (page < 0) {
			page = 0;
		}
		
		if (size < 0) {
			size = Integer.MAX_VALUE;
		}

		return new PageRequest(page, size, this.getSort(sortFields));
	}
	
	private Sort getSort(String... sortFields) {
		Sort sort = new Sort(Direction.ASC, "id");
		if (sortFields == null || sortFields.length == 0) {
			return sort;
		}
		
		List<String> listFields = new ArrayList<>();
		for (String field : sortFields) {
			if (!StringUtils.isEmpty(field)) {
				listFields.add(field);
			}
		}
		
		if (listFields.isEmpty()) {
			return sort;
		}
		
		return new Sort(Direction.ASC, listFields);
	}
	
	protected PageRequest getPageRequest(int page, int size) {
		return this.getPageRequest(page, size, "");
	}
}
