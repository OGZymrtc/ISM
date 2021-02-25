package com.ogzymrtc.ism.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ogzymrtc.ism.dto.IssueHistoryDto;
import com.ogzymrtc.ism.entity.IssueHistory;
import com.ogzymrtc.ism.repository.IssueHistoryRepository;
import com.ogzymrtc.ism.service.IssueHistoryService;
import com.ogzymrtc.ism.util.TPage;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService{
	private final IssueHistoryRepository issueHistoryRepository;
	private final ModelMapper modelMapper;
	
	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository, ModelMapper modelMapper) {
		this.issueHistoryRepository = issueHistoryRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public IssueHistoryDto save(IssueHistoryDto issueHistory) {
		IssueHistory ih = modelMapper.map(issueHistory, IssueHistory.class);
		ih = issueHistoryRepository.save(ih);
		issueHistory.setId(ih.getId());
		return issueHistory;
	}

	@Override
	public IssueHistoryDto getById(Long id) {
		IssueHistory ih = issueHistoryRepository.getOne(id);
		return modelMapper.map(ih, IssueHistoryDto.class);
	}

	@Override
	public TPage<IssueHistoryDto> getAllPageable(Pageable pageable) {
		Page<IssueHistory> data = issueHistoryRepository.findAll(pageable);
		TPage<IssueHistoryDto> response = new TPage<IssueHistoryDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueHistoryDto[].class)));
		return response;
	}

	@Override
	public Boolean delete(IssueHistoryDto issueHistory) {
		issueHistoryRepository.deleteById(issueHistory.getId());
		return Boolean.TRUE;
	}
}
