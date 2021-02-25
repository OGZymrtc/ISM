package com.ogzymrtc.ism.entity;

import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "issue_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IssueHistory extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "description",length = 1000)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    
    @Column(name = "details",length = 4000)
    private String details;

	@JoinColumn(name = "issue_id")
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private Issue issue;
	
	@Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
	@JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
	private User assignee;
}
