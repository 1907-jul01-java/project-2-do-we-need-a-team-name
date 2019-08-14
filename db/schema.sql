DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS users;
create table users (
  userid serial not null primary key,
  username text not null unique,
  pw text not null,
  guestid text 
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
create table movie_tracker (
  id serial primary key,
  username text not null REFERENCES users(username), 
  movieid text not null,
  watched boolean not null DEFAULT false,
  tracked boolean not null DEFAULT false,
)
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

insert into
  movie_tracker (userid, movieid, watched, tracked)
VALUES
  ( 
    1,
    '420818'
    false,
    true
  )