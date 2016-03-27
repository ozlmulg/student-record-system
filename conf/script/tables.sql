    drop table if exists student;

    create table student (
        id integer not null auto_increment,
        name varchar(255),
        surname varchar(255) not null,
        grade integer not null,
        primary key (id)
    );
