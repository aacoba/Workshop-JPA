CREATE TABLE artist (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  genre_name VARCHAR(255) NOT NULL,

  PRIMARY KEY(id)
);
ALTER TABLE concert DROP COLUMN artist;
ALTER TABLE concert ADD artist_id BIGINT NOT NULL;
ALTER TABLE concert ADD CONSTRAINT artist_id FOREIGN KEY (artist_id) REFERENCES artist(id);