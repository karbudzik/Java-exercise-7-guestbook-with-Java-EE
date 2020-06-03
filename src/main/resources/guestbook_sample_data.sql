CREATE TABLE IF NOT EXISTS entries (
    entry_id SERIAL PRIMARY KEY,
    author_name character varying(255) NOT NULL,
    author_city character varying(255) NOT NULL,
    entry_content character varying(255) NOT NULL,
    entry_date DATE NOT NULL
);

-- insert into entries (author_name, author_city, entry_content, entry_date) values ('Karolina', 'Kraków', 'Super strona', '2019-01-15');
-- insert into entries (author_name, author_city, entry_content, entry_date) values ('Jakub', 'London', 'Lorem ipsum', '2020-01-15');
-- insert into entries (author_name, author_city, entry_content, entry_date) values ('Stasiek Kowalski', 'Warszawa', 'Ale ładne', '2019-01-15');