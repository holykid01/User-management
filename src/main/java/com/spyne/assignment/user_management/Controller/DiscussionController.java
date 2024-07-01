package com.spyne.assignment.user_management.Controller;

import com.spyne.assignment.user_management.Models.Discussion;
import com.spyne.assignment.user_management.Services.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion) {
        return ResponseEntity.ok(discussionService.createDiscussion(discussion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discussion> updateDiscussion(@PathVariable Long id, @RequestBody Discussion discussionDetails) {
        return ResponseEntity.ok(discussionService.updateDiscussion(id, discussionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tags")
    public ResponseEntity<List<Discussion>> getDiscussionsByHashtag(@RequestParam String hashtag) {
        return ResponseEntity.ok(discussionService.getDiscussionsByHashtag(hashtag));
    }

    @GetMapping("/text")
    public ResponseEntity<List<Discussion>> getDiscussionsByText(@RequestParam String text) {
        return ResponseEntity.ok(discussionService.getDiscussionsByText(text));
    }
}
