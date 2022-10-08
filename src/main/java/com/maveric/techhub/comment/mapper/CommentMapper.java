package com.maveric.techhub.comment.mapper;

import com.maveric.techhub.comment.entity.Comment;
import com.maveric.techhub.comment.model.CommentRequest;
import com.maveric.techhub.comment.model.CommentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toEntity(CommentRequest request);
    CommentDTO toDTO(Comment comment);

    List<CommentDTO> toDTO(List<Comment> comments);

}
