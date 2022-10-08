package com.maveric.techhub.comment.entity;

import com.maveric.techhub.comment.util.ServiceConstants;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @Column
    private String id;
    @Column
    private String comment;
    @Column
    private String commentedBy;
    @Column
    private String typeId;
    @Column
    private String type;
    @Column
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
