create table ni1216332_1sql1.Vampire_Charakter
(
    id               int auto_increment
        primary key,
    charName         text                 not null,
    spieler          text                 not null,
    wesen            text                 not null,
    verhalten        text                 not null,
    clan             text                 not null,
    generation       int        default 0 not null,
    zuflucht         text                 not null,
    weg              text                 not null,
    wegWert          int        default 0 not null,
    aura             text                 not null,
    auraWert         int        default 0 not null,
    auraAnzeigen     tinyint(1) default 0 not null,
    willenskraft     int        default 0 not null,
    willenskraftPool int        default 0 not null,
    blutvorrat       int        default 0 not null,
    gesundheit       int        default 0 not null,
    gesundheit2      int        default 0 not null,
    erfahrung        int        default 0 not null
);

create table ni1216332_1sql1.Vampire_Charakter_andereEigenschaften
(
    id          int auto_increment
        primary key,
    f_id        int default 0 not null,
    value       int default 0 not null,
    bezeichnung text          null,
    constraint andereEigenschaftenWert_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_attributeGeistig
(
    id    int auto_increment
        primary key,
    f_id  int default 0 not null,
    value int default 0 not null,
    constraint attributeGeistig_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_attributeGesellschaftlich
(
    id    int auto_increment
        primary key,
    f_id  int           not null,
    value int default 0 not null,
    constraint attributeGesellschaftlich_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_attributeKoerperlich
(
    id    int auto_increment
        primary key,
    f_id  int default 0 not null,
    value int default 0 not null,
    constraint Vampire_Charakter_attributeKoerperlich_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_clansschwaeche
(
    id    int auto_increment
        primary key,
    f_id  int default 0 not null,
    value text          not null,
    constraint clansschweache_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_faehigkeitenFertigkeiten
(
    id    int auto_increment
        primary key,
    f_id  int default 0 not null,
    value int default 0 not null,
    constraint faehigkeitenFertigkeiten_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_faehigkeitenKenntnisse
(
    id    int auto_increment
        primary key,
    f_id  int default 0 not null,
    value int default 0 not null,
    constraint faehigkeitenKenntnisse_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_faehigkeitenTalente
(
    id    int auto_increment
        primary key,
    f_id  int default 0 not null,
    value int default 0 not null,
    constraint faehigkeitenTalente_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_vorteileDisziplinen
(
    id          int auto_increment
        primary key,
    f_id        int default 0 not null,
    value       int default 0 not null,
    bezeichnung text          null,
    constraint vorteileDisziplinenWert_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_vorteileHintergrund
(
    id          int auto_increment
        primary key,
    f_id        int default 0 not null,
    value       int default 0 not null,
    bezeichnung text          null,
    constraint vorteileHintergrundWert_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);

create table ni1216332_1sql1.Vampire_Charakter_vorteileTugenden
(
    id           int auto_increment
        primary key,
    f_id         int default 0 not null,
    value        int default 0 not null,
    entscheidung text          null,
    constraint vorteileTugenden_Vampire_Charakter_id_fk
        foreign key (f_id) references ni1216332_1sql1.Vampire_Charakter (id)
            on update cascade on delete cascade
);


