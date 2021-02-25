package com.ogzymrtc.ism.service;

import org.springframework.data.domain.Pageable;

import com.ogzymrtc.ism.dto.IssueHistoryDto;
import com.ogzymrtc.ism.util.TPage;

public interface IssueHistoryService {
	
	IssueHistoryDto save(IssueHistoryDto issueHistory);
	
	IssueHistoryDto getById(Long id);
	
	TPage<IssueHistoryDto> getAllPageable(Pageable pageable);
	
	Boolean delete(IssueHistoryDto issueHistory);
}
