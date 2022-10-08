package com.maveric.techhub.comment.model;

import com.maveric.techhub.comment.util.ServiceConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CommentRequest {

    @NotBlank(message = ServiceConstants.COMMENT_IS_MANDATORY)
    private String comment;
    @NotBlank(message = ServiceConstants.COMMENTED_BY_MANDATORY)
    private String commentedBy;
    @NotBlank(message = ServiceConstants.TYPE_ID_IS_MANDATORY)
    private String typeId;
    @NotBlank(message = ServiceConstants.TYPE_IS_MANDATORY)
    private String type;

}
