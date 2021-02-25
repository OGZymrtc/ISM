package com.ogzymrtc.ism.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ogzymrtc.ism.dto.IssueDto;
import com.ogzymrtc.ism.entity.Issue;
import com.ogzymrtc.ism.repository.IssueRepository;
import com.ogzymrtc.ism.service.IssueService;
import com.ogzymrtc.ism.util.TPage;

@Service
public class IssueServiceImpl implements IssueService{
	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	
	public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
		this.issueRepository = issueRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public IssueDto save(IssueDto issue) {
		// TODO Auto-generated method stub
		if(issue.getDate() == null)
			throw new IllegalArgumentException("Issue Date cannot be null");
		Issue issueEntity = modelMapper.map(issue, Issue.class);
		issueEntity = issueRepository.save(issueEntity);
		issue.setId(issueEntity.getId());
		return issue;
	}

	@Override
	public IssueDto getById(Long id) {
		Issue issue = issueRepository.getOne(id);
		return modelMapper.map(issue, IssueDto.class);
	}

	@Override
	public TPage<IssueDto> getAllPageable(Pageable pageable) {
		Page<Issue> data = issueRepository.findAll(pageable);
		TPage<IssueDto> response = new TPage<IssueDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
		return response;
	}

	@Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

	@Override
	public IssueDto update(Long id, IssueDto issue) {
		// TODO Auto-generated method stub
		return null;
	}
}
