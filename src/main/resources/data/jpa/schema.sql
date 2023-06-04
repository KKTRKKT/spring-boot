-- spring.jpa.hibernate.ddl-auto=create-drop으로 로그 생성후 붙여넣기
-- resource 아래에다 위치시키면 자동으로 실행됨
-- spring.datasource.platform=postgres 설정하면 schema-postgres.sql 실행됨

drop table if exists account cascade;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start 1 increment 1;
create table account (id int8 not null, email varchar(255), password varchar(255), username varchar(255), primary key (id));