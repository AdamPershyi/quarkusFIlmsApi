CREATE TABLE "genre"
(
    "name" TEXT NOT NULL,


    CONSTRAINT "genre_pk" PRIMARY KEY ("name")
);
INSERT INTO "genre" ("name")
VALUES ('Action'),
       ('Adventure'),
       ('Comedy'),
       ('Crime'),
       ('Horror');


CREATE TABLE films
(
    "id"            UUID                     NOT NULL DEFAULT gen_random_uuid(),
    "title"         TEXT,
    "genre"         TEXT,
    "about_film"    TEXT,
    "released_date" TEXT,
    "released_city" TEXT,
    "budget"        TEXT,
    "created_at"    TIMESTAMP WITH TIME ZONE NOT NULL,
    "updated_at"    TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT "films_pk" PRIMARY KEY ("id"),
    CONSTRAINT "films_fk" FOREIGN KEY ("genre") REFERENCES "genre" ("name") ON DELETE RESTRICT ON UPDATE CASCADE
);