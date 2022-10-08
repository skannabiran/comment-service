package com.maveric.techhub.comment.repository;

import com.maveric.techhub.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, String> {

    Optional<Comment> findById(String Id);

}