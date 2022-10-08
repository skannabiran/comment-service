package com.maveric.techhub.comment.service;

import com.maveric.techhub.comment.entity.Comment;
import com.maveric.techhub.comment.exception.EntityNotFoundException;
import com.maveric.techhub.comment.model.CommentDTO;
import com.maveric.techhub.comment.model.CommentRequest;
import com.maveric.techhub.comment.repository.CommentRepository;
import com.maveric.techhub.comment.mapper.CommentMapper;
import com.maveric.techhub.comment.model.ServiceResponse;
import com.maveric.techhub.comment.util.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public ResponseEntity<ServiceResponse> createComment(CommentRequest commentRequest) {
            Comment comment = commentMapper.toEntity(commentRequest);
            comment.setId(ServiceConstants._UUID());
            commentRepository.save(comment);
            CommentDTO commentDTO = commentMapper.toDTO(comment);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ServiceResponse.builder().response(commentDTO).build());
    }

    public ResponseEntity<ServiceResponse> getComment(String id) {
        Optional<Comment> optionalUser = commentRepository.findById(id);
        if (optionalUser.isPresent()) {
            Comment comment = optionalUser.get();
            CommentDTO commentDTO = commentMapper.toDTO(comment);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(commentDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> updateComment(String id, CommentRequest commentRequest) {
        Optional<Comment> optionalUserDB = commentRepository.findById(id);
        if (optionalUserDB.isPresent()) {
            Comment commentDB = optionalUserDB.get();
            Comment comment = commentMapper.toEntity(commentRequest);
            comment.setId(commentDB.getId());
            commentRepository.save(comment);
            CommentDTO commentDTO = commentMapper.toDTO(comment);
            return ResponseEntity.status(HttpStatus.OK).
                    body(ServiceResponse.builder().response(commentDTO).build());
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> deleteComment(String id) {
        Optional<Comment> optionalUser = commentRepository.findById(id);
        if (optionalUser.isPresent()) {
            Comment comment = optionalUser.get();
            commentRepository.delete(comment);
            ServiceResponse response = ServiceResponse.builder().
                    message(String.format(ServiceConstants.ENTITY_DELETED, id)).build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new EntityNotFoundException(String.format(ServiceConstants.ENTITY_NOT_FOUND, id));
    }

    public ResponseEntity<ServiceResponse> getComments() {
        ServiceResponse response = ServiceResponse.builder().build();
        List<Comment> comments = commentRepository.findAll();
        if (!comments.isEmpty()) {
            List<CommentDTO> commentDTOS = commentMapper.toDTO(comments);
            response.setResponse(commentDTOS);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
