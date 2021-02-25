package com.ogzymrtc.ism.service;

import org.springframework.data.domain.Pageable;

import com.ogzymrtc.ism.dto.IssueDto;
import com.ogzymrtc.ism.util.TPage;

public interface IssueService {
	
	IssueDto save(IssueDto issue);
	
	IssueDto getById(Long id);
	
	TPage<IssueDto> getAllPageable(Pageable pageable);
	
	Boolean delete(Long issueId);
	
	IssueDto update(Long id, IssueDto issue);
}
