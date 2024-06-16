CREATE TABLE discussion (
                            id SERIAL PRIMARY KEY,
                            discussion_id VARCHAR(50) UNIQUE NOT NULL,
                            discussion TEXT NOT NULL,
                            image BYTEA, -- Using BYTEA type for storing binary data (image)
                            user_id VARCHAR(50) NOT NULL,
                            hash_tag VARCHAR(50),
                            number_of_likes INTEGER DEFAULT 0,
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            CONSTRAINT fk_user_id
                                FOREIGN KEY (user_id)
                                    REFERENCES user_details (user_id)
);

-- Create indexes to improve query performance
CREATE INDEX idx_discussion_user_id ON discussion(discussion_id);
CREATE INDEX idx_discussion_posted_by ON discussion(user_id);
