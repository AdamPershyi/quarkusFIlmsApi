CREATE TABLE film_genres
(
    "film_id" UUID NOT NULL,
    "genre_name" TEXT NOT NULL,
    CONSTRAINT "fk_film" FOREIGN KEY ("film_id") REFERENCES "films" ("id") ON DELETE CASCADE,
    CONSTRAINT "fk_genre" FOREIGN KEY ("genre_name") REFERENCES "genre" ("name") ON DELETE RESTRICT,
    CONSTRAINT "film_genres_pk" PRIMARY KEY ("film_id", "genre_name")
);

alter table films drop column genre;
