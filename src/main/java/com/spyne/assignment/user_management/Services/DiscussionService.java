package com.spyne.assignment.user_management.Services;

import com.spyne.assignment.user_management.Models.Discussion;
import com.spyne.assignment.user_management.Repositories.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    public Discussion createDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    public Discussion updateDiscussion(Long id, Discussion discussionDetails) {
        Discussion discussion = discussionRepository.findById(id).orElseThrow(() -> new RuntimeException("Discussion not found"));
        discussion.setText(discussionDetails.getText());
        discussion.setImage(discussionDetails.getImage());
        discussion.setHashtags(discussionDetails.getHashtags());
        return discussionRepository.save(discussion);
    }

    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
    }

    public List<Discussion> getDiscussionsByHashtag(String hashtag) {
        return discussionRepository.findByHashtagsContaining(hashtag);
    }

    public List<Discussion> getDiscussionsByText(String text) {
        return discussionRepository.findByTextContaining(text);
    }
}
