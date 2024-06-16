package com.example.spyne.controller;

import com.example.spyne.models.DiscussionRequest;
import com.example.spyne.models.Response;
import com.example.spyne.models.UserRequest;
import com.example.spyne.service.DiscussionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@Slf4j
public class DiscussionController {
    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    @PostMapping("add/discussion")
    public ResponseEntity<Response<String>> addDiscussion(@RequestParam String userId, @RequestBody DiscussionRequest discussionRequest) {
        try {
            discussionService.addDiscussion(userId, discussionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>("success", null));
        } catch (Exception e) {
            log.error("unable to add discussion", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>("failed", null));
        }
    }

    @PutMapping("update/discussion")
    public ResponseEntity<Response<String>> updateDiscussion(@RequestParam String discussionId, @RequestBody DiscussionRequest discussionRequest) {
        try {
            discussionService.updateDiscussion(discussionId, discussionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(new Response<>("success", null));
        } catch (Exception e) {
            log.error("unable to update discussion", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>("failed", null));
        }
    }

    @DeleteMapping("delete/discussion/{discussionId}")
    public ResponseEntity<Response<String>> deleteDiscussion(@PathVariable String discussionId) {
        try {
            discussionService.deleteDiscussion(discussionId);
            return ResponseEntity.status(HttpStatus.OK).body(new Response<>("success", null));
        } catch (Exception e) {
            log.error("unable to delete discussion", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response<>("failed", null));
        }
    }


}
