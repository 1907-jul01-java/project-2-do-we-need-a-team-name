DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS users;
create table users (
  userid serial not null primary key,
  username text not null unique,
  pw text not null
);
create table reviews (
  reviewid serial not null primary key,
  usern text not null REFERENCES users(username),
  movie text not null,
  rating integer not null CHECK (
    rating >= 0
    AND rating <= 10
  ),
  time_created TIMESTAMPTZ not null default NOW(),
  review_body text
);
insert into
  users (username, pw)
VALUES
  ('test', 'password');
insert into
  reviews (usern, movie, rating, review_body)
VALUES
  (
    'test',
    'Shrek 2',
    8,
    'I can''t believe how good this movie is!'
  );