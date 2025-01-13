create table messages (
  id SERIAL PRIMARY KEY,
  LANGUAGE_CODE varchar(2) not null,
  MESSAGE varchar(50) not null
);
