CREATE TABLE entries (
    entry_id SERIAL PRIMARY KEY,
    author_name character varying(255) NOT NULL,
    author_city character varying(255) NOT NULL,
    entry_content character varying(255) NOT NULL,
    entry_date DATE NOT NULL
);