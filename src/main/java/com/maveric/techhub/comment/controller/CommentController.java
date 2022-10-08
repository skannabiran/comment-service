package com.maveric.techhub.comment.controller;
import com.maveric.techhub.comment.model.CommentRequest;
import com.maveric.techhub.comment.model.ServiceResponse;
import com.maveric.techhub.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * CommentController is the class to manage for employee Comments
 * @author      Kannabiran Shanmugam
 * @version     %I%, %G%
 * @since       1.0
 */
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
class CommentController {

    private final CommentService commentService;

    @PostMapping
    ResponseEntity<ServiceResponse> createComment(@Valid @RequestBody CommentRequest commentRequest) {
        return commentService.createComment(commentRequest);
    }

    @GetMapping("/{id}")
    ResponseEntity<ServiceResponse> getComment(@PathVariable(name = "id") String id) {
        return commentService.getComment(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<ServiceResponse> updateComment(@PathVariable(name = "id") String id,
                                            @RequestBody CommentRequest commentRequest) {
        return commentService.updateComment(id, commentRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ServiceResponse> deleteComment(@PathVariable(name = "id") String id) {
        return commentService.deleteComment(id);
    }

    @GetMapping
    ResponseEntity<ServiceResponse> getComments() {
        return commentService.getComments();
    }

}