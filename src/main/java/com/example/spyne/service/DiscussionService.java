package com.example.spyne.service;

import com.example.spyne.db.DiscussionsDbService;
import com.example.spyne.db.DiscussionsEntity;
import com.example.spyne.db.DiscussionsRepository;
import com.example.spyne.db.UserDetailsEntity;
import com.example.spyne.models.DiscussionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class DiscussionService {

    private final DiscussionsRepository discussionsRepository;
    private DiscussionsDbService discussionsDbService;

    public DiscussionService(DiscussionsDbService discussionsDbService, DiscussionsRepository discussionsRepository) {
        this.discussionsDbService = discussionsDbService;
        this.discussionsRepository = discussionsRepository;
    }

    public void addDiscussion(String userId, DiscussionRequest discussionRequest) {
        DiscussionsEntity discussionsEntity = new DiscussionsEntity();
        discussionsEntity.setUserId(userId);
        discussionsEntity.setDiscussion(discussionRequest.getDiscussion());
        discussionsEntity.setImage(discussionRequest.getImage());
        discussionsEntity.setHashTag(discussionRequest.getHashTag());
        discussionsEntity.setDiscussionId(UUID.randomUUID().toString());
        discussionsDbService.createDiscussion(discussionsEntity);
    }

    public void updateDiscussion(String discussionId, DiscussionRequest discussionRequest) {
        Optional<DiscussionsEntity> discussionsEntityOp = discussionsDbService.getDiscussionByDiscussionId(discussionId);
        if (discussionsEntityOp.isEmpty()) {
            log.error("Discussion with id {} not found", discussionId);
            return;
        }
        DiscussionsEntity discussionsEntity = discussionsEntityOp.get();
        discussionsEntity.setDiscussion(discussionRequest.getDiscussion());
        discussionsEntity.setImage(discussionRequest.getImage());
        discussionsEntity.setHashTag(discussionRequest.getHashTag());
        discussionsDbService.createDiscussion(discussionsEntity);
    }

    public void deleteDiscussion(String discussionId) {
        Optional<DiscussionsEntity> discussionsEntityOp = discussionsDbService.getDiscussionByDiscussionId(discussionId);
        if (discussionsEntityOp.isEmpty()) {
            log.error("Discussion with id {} not found", discussionId);
            return;
        }
        DiscussionsEntity discussionsEntity = discussionsEntityOp.get();
        discussionsDbService.deleteDiscussion(discussionsEntity);
    }
}
