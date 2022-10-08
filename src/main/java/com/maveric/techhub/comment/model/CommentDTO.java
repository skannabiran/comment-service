package com.maveric.techhub.comment.model;

import com.maveric.techhub.comment.util.ServiceConstants;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private String id;
    private String comment;
    private String commentedBy;
    private String typeId;
    private String type;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
