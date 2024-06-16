package com.example.spyne.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DiscussionsDbService {
    private final DiscussionsRepository discussionsRepository;

    public DiscussionsDbService(DiscussionsRepository discussionsRepository) {
        this.discussionsRepository = discussionsRepository;
    }

    public void createDiscussion(DiscussionsEntity discussionsEntity) {
        discussionsRepository.save(discussionsEntity);
    }

    public Optional<DiscussionsEntity> getDiscussionByDiscussionId(String discussionId) {
        return discussionsRepository.findByDiscussionId(discussionId);
    }

    public void deleteDiscussion(DiscussionsEntity discussionsEntity) {
        discussionsRepository.delete(discussionsEntity);
    }
}
