set echo off
set feed off

@ c:\sql\script_info\alter_profile             -- �p�X���[�h�̊����𖳊����ɕύX

/** ���[�U�����݂��Ă���ꍇ�A�폜���� **/

DECLARE
  v_cnt NUMBER;
BEGIN
  SELECT COUNT(username) INTO v_cnt
  FROM dba_users
  WHERE username = 'SHOP_ADMIN';

  IF v_cnt = 1 THEN
    EXECUTE IMMEDIATE 'DROP USER shop_admin CASCADE';
  END IF;
END;
/

@ c:\sql\SQL_shop\H27_database_createuser        -- ���[�U���쐬���܂��B

conn shop_admin /admin

@ c:\sql\SQL_shop\H27_database_table
@ c:\sql\SQL_shop\H27_database_sequence
@ c:\sql\SQL_shop\H27_database_view
@ c:\sql\SQL_shop\H27_database_alter

set serveroutput on
BEGIN
  DBMS_OUTPUT.PUT_LINE('.');
  DBMS_OUTPUT.PUT_LINE('�I�����܂���');
END;
/

SHOW USER

set feed 6
set echo on