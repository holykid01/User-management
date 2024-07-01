package com.spyne.assignment.user_management.Repositories;

import com.spyne.assignment.user_management.Models.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByHashtagsContaining(String hashtag);
    List<Discussion> findByTextContaining(String text);
}
