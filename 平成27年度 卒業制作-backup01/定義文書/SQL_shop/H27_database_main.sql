set echo off
set feed off

@ c:\sql\script_info\alter_profile             -- パスワードの期限を無期限に変更

/** ユーザが存在している場合、削除する **/

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

@ c:\sql\SQL_shop\H27_database_createuser        -- ユーザを作成します。

conn shop_admin /admin

@ c:\sql\SQL_shop\H27_database_table
@ c:\sql\SQL_shop\H27_database_sequence
@ c:\sql\SQL_shop\H27_database_view
@ c:\sql\SQL_shop\H27_database_alter

set serveroutput on
BEGIN
  DBMS_OUTPUT.PUT_LINE('.');
  DBMS_OUTPUT.PUT_LINE('終了しました');
END;
/

SHOW USER

set feed 6
set echo on