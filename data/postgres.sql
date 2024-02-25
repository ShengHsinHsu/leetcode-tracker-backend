DROP TABLE IF EXISTS leetcode.tags;
DROP TABLE IF EXISTS leetcode.records;
DROP TABLE IF EXISTS leetcode.questions;



CREATE TABLE IF NOT EXISTS leetcode.questions
(
    question_id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    title text,
    topic text,
    is_important boolean,
    note_link text,
    last_update_dt timestamp(0) without time zone DEFAULT now(),
    last_modified_by text DEFAULT 'unknown'
);


CREATE TABLE IF NOT EXISTS leetcode.tags
(
    tag_id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    question_id uuid NOT NULL references leetcode.questions (question_id),
    tag_name text,
    last_update_dt timestamp(0) without time zone DEFAULT now(),
    last_modified_by text DEFAULT 'unknown'
);


CREATE TABLE IF NOT EXISTS leetcode.records
(
    record_id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
	question_id uuid NOT NULL references leetcode.questions (question_id),
    finished_date timestamp(0) without time zone,
	is_pass boolean,
    last_update_dt timestamp(0) without time zone DEFAULT now(),
    last_modified_by text DEFAULT 'unknown'
);

SELECT *
FROM leetcode.questions q
LEFT JOIN leetcode.tags tag ON q.question_id = tag.question_id
LEFT JOIN leetcode.records r ON q.question_id = r.question_id;

SELECT * FROM leetcode.tags