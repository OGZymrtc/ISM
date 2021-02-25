package com.ogzymrtc.ism.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ogzymrtc.ism.dto.ProjectDto;
import com.ogzymrtc.ism.util.TPage;

public interface ProjectService {
	
	ProjectDto save(ProjectDto project);

	ProjectDto getById(Long id);

	List<ProjectDto> getByProjectCode(String projectCode);

	List<ProjectDto> getByProjectCodeContains(String projectCode);

	TPage<ProjectDto> getAllPageable(Pageable pageable);

	Boolean delete(ProjectDto project);
	
	ProjectDto update(Long id, ProjectDto project);
}
