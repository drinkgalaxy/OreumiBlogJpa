create table if not exists article (
    id BIGINT AUTO_INCREMENT primary key,
    title varchar(255) not null,
    content varchar(255) not null,
    created_at timestamp,
    updated_at timestamp
);

INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목1', '내용1', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목2', '내용2', NOW(), NOW());
INSERT INTO article (title, content, created_at, updated_at) VALUES ('제목3', '내용3', NOW(), NOW());

create table if not exists comment (
      id BIGINT AUTO_INCREMENT primary key,
      article_id BIGINT not null,
      body varchar(255) not null,
      created_at timestamp
);

INSERT INTO comment (article_id, body, created_at) VALUES ('1', '댓글 내용1', NOW());
INSERT INTO comment (article_id, body, created_at) VALUES ('2', '댓글 내용2', NOW());
INSERT INTO comment (article_id, body, created_at) VALUES ('3', '댓글 내용3', NOW());

