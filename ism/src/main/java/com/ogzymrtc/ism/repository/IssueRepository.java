package com.ogzymrtc.ism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogzymrtc.ism.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

}
