create table phoneInfo_basic (
idx number(6) constraint info_idx primary key not null,
fr_name varchar2(20) default '친구이름' not null,
fr_phoneNumber varchar2(20) default '친구 전화번호' not null,
fr_email varchar2(20) default '친구 이메일',
fr_address varchar2(20) default '친구 주소',
fr_regdate date default sysdate 
);

create table phoneInfo_univ (
idx number(6) constraint univInfo_idx primary key not null,
fr_u_major varchar2(20) default 'n' not null,
fr_u_year number(1) default '1' constraint univ_year check (0<fr_u_year and fr_u_year<5) not null,
fr_ref number(7) constraint univ_fk references phoneInfo_basic(idx) not null
);

create table phoneInfo_com (
idx number(6) constraint comInfo_idx primary key not null,
fr_c_company varchar2(20) default 'n' not null,
fr_ref number(6) constraint comInfo_fk references phoneInfo_basic(idx) not null
);

