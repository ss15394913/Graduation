-- �V���b�s���O�T�C�g�p���[�U���쐬���܂�(���[�U���Fshop_admin�@�p�X���[�h�Fadmin)

CREATE USER shop_admin
IDENTIFIED BY admin
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON users;


-- �e�[�u���쐬���̌�����^���܂�

GRANT connect, resource,
      create table,
      create sequence,
      create view,
      create synonym,
      create public synonym,
      drop public synonym
TO shop_admin;