ALTER TABLE concert
  DROP COLUMN artist,
  ADD COLUMN artist_id BIGINT NOT NULL,
  ADD CONSTRAINT artist_id FOREIGN KEY (artist_id) REFERENCES artist(id)