-- ショッピングサイト用ユーザを作成します(ユーザ名：shop_admin　パスワード：admin)

CREATE USER shop_admin
IDENTIFIED BY admin
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON users;


-- テーブル作成等の権限を与えます

GRANT connect, resource,
      create table,
      create sequence,
      create view,
      create synonym,
      create public synonym,
      drop public synonym
TO shop_admin;