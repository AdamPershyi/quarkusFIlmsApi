CREATE TABLE "actors"
(
    "name" TEXT NOT NULL,

    CONSTRAINT "actors_name_pk" PRIMARY KEY ("name")
);
INSERT INTO "actors" ("name")
VALUES ('CHRIS_HEMSWORTH'),
       ('WILL_SMITH'),
       ('BRAD_PITT');


CREATE TABLE film_actors
(
    "film_id" UUID NOT NULL,
    "actor_name" TEXT NOT NULL,
    CONSTRAINT "fk_film" FOREIGN KEY ("film_id") REFERENCES "films" ("id") ON DELETE CASCADE,
    CONSTRAINT "fk_actors" FOREIGN KEY ("actor_name") REFERENCES "actors" ("name") ON DELETE RESTRICT,
    CONSTRAINT "film_actors_pk" PRIMARY KEY ("film_id", "actor_name")
);