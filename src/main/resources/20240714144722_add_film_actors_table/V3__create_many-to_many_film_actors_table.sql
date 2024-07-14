CREATE TABLE "actor"
(
    "id"       UUID NOT NULL DEFAULT gen_random_uuid(),
    "name"     TEXT NOT NULL,
    "sur_name" TEXT NOT NULL,

    CONSTRAINT "actor_id_pk" PRIMARY KEY ("id")
);
INSERT INTO "actor" ("name", "sur_name")
VALUES ('Chris', 'Hemsworth'),
       ('Will', 'Smith'),
       ('Brad', 'Pitt');


CREATE TABLE film_actors
(
    film_id  UUID REFERENCES films (id),
    actor_id UUID REFERENCES actor (id),
    PRIMARY KEY (film_id, actor_id)
);