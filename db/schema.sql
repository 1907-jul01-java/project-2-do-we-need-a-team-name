DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS users;
SET
  timezone = 'America/Chicago';
create table users (
    userid serial not null primary key,
    username text not null unique,
    pw text not null
  );
create table reviews (
    reviewid serial not null primary key,
    userid integer not null REFERENCES users(userid),
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
  reviews (userid, movie, rating, review_body)
VALUES
  (
    1,
    'Shrek 2',
    8,
    'I can''t believe how good this movie is!'
  );