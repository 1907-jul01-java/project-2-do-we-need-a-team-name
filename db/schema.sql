DROP TABLE IF EXISTS users;
create table users (
  userid serial not null primary key,
  username text not null unique,
  pw text not null
);
insert into
  users (username, pw)
VALUES
  ('test', 'password');