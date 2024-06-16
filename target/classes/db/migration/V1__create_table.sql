CREATE TABLE user_details (
                              id SERIAL PRIMARY KEY,
                              user_id VARCHAR(50) UNIQUE NOT NULL,
                              name VARCHAR(100) NOT NULL,
                              mobile VARCHAR(15) UNIQUE NOT NULL,
                              email_id VARCHAR(100) UNIQUE NOT NULL,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

