INSERT INTO category
VALUES(category_id_seq.NEXTVAL,'testcat');

INSERT INTO sub_category
VALUES(sub_category_id_seq.NEXTVAL,'testcat',category_id_seq.CURRVAL);

INSERT INTO product
VALUES('99999999','testproduct',100,'testdesc',
category_id_seq.CURRVAL,sub_category_id_seq.CURRVAL,
'S','color',SYSDATE);

INSERT INTO product_stock
VALUES('99999999',45);


INSERT INTO tag
VALUES(1,'testtag','99999999');

INSERT INTO product_image
VALUES(product_image_id_seq.NEXTVAL,'testpath','99999999');

INSERT INTO member_status
VALUES(9,'test');

INSERT INTO member
VALUES(member_id_seq.NEXTVAL,'test name','test kana',
'0001111','test_address','0001110000',SYSDATE,'test@test.test',
'test_pass',9);

INSERT INTO purchase_order
VALUES(purchase_order_id_seq.NEXTVAL,SYSDATE,
'test_status',member_id_seq.CURRVAL);

INSERT INTO purchase_order_detail
VALUES(purchase_order_detail_id_seq.NEXTVAL,
purchase_order_id_seq.CURRVAL,'99999999',3);

INSERT INTO favorite
VALUES(member_id_seq.CURRVAL,'99999999');

COLUMN PRODUCT_NAME FORMAT A20
COLUMN PRODUCT_DESCRIPTION FORMAT A20
COLUMN PRODUCT_SIZE FORMAT A6
COLUMN PRODUCT_PRICE FORMAT 99999999
COLUMN CATEGORY_ID FORMAT A10

--INSERT＆ビュー作成の後、テストする
select * from new_product_view;
select * from purchase_ranking_view;
select * from product_information_view;

SELECT member_id, purchase_order_id, purchase_order_date, 
       purchase_order_delivery_status, purchase_order_detail_id
       product_id, purchase_count
FROM purchase_order JOIN purchase_order_detail
     USING(purchase_order_id)
ORDER BY purchase_order_date DESC
;

--同じ商品を再度5個購入する。3+5 = 8個

INSERT INTO purchase_order
VALUES(purchase_order_id_seq.NEXTVAL,SYSDATE,
'test_status',member_id_seq.CURRVAL);

INSERT INTO purchase_order_detail
VALUES(purchase_order_detail_id_seq.NEXTVAL,
purchase_order_id_seq.CURRVAL,'99999999',5);

SELECT member_id, purchase_order_id, purchase_order_date, 
       purchase_order_delivery_status, purchase_order_detail_id
       product_id, purchase_count
FROM purchase_order JOIN purchase_order_detail
     USING(purchase_order_id)
ORDER BY purchase_order_date DESC
;
--新しい購入が先に出力されることを確認できた。

--同じ名前の商品を増やす。

INSERT INTO product
VALUES('99999998','testproduct',100,'testdesc',
category_id_seq.CURRVAL,sub_category_id_seq.CURRVAL,
'S','color',SYSDATE);

INSERT INTO product_stock
VALUES('99999998',90);

--同じ名前の新しい商品(id99999998)を12個買う。

INSERT INTO purchase_order
VALUES(purchase_order_id_seq.NEXTVAL,SYSDATE,
'test_status',member_id_seq.CURRVAL);

INSERT INTO purchase_order_detail
VALUES(purchase_order_detail_id_seq.NEXTVAL,
purchase_order_id_seq.CURRVAL,'99999998',12);

select * from purchase_ranking_view;

--同じ名前の商品は同じ購入数にカウントされることを確認した。

--異なる名前の商品を増やす。

INSERT INTO product
VALUES('99999997','testproduct2',600,'testdesc',
0,0,
'M','color',SYSDATE);

INSERT INTO product_stock
VALUES('99999997',50);

--新しい異なる名前の商品を10個買う。

INSERT INTO purchase_order
VALUES(purchase_order_id_seq.NEXTVAL,SYSDATE,
'test_status',0);
INSERT INTO purchase_order_detail
VALUES(4,22,'99999997',10);

select * from purchase_ranking_view;


--再び、新しい異なる名前の商品を25個買う。

INSERT INTO purchase_order
VALUES(purchase_order_id_seq.NEXTVAL,SYSDATE,
'test_status',0);
INSERT INTO purchase_order_detail
VALUES(5,23,'99999997',25);

select * from purchase_ranking_view;

--商品ランキングの順位が逆転したことを確認できた。