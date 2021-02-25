package com.ogzymrtc.ism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogzymrtc.ism.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

}

