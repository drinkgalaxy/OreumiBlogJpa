package com.estsoft.blogjpa.repository;


import com.estsoft.blogjpa.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
    @Query("SELECT c FROM Comment c WHERE c.article.id = :articleId AND c.id = :commentId")
    Comment findArticleIdAndCommentId(Long articleId, Long commentId);
}