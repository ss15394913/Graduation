--�w���������L���O�𓾂邽�߂̃r���[�B�w�������������i���ɕ\������B
CREATE OR REPLACE VIEW purchase_ranking_view AS
SELECT product_name, product_price, NVL(purchase_count_sum,0) AS purchase_count_sum
FROM (SELECT product_name, product_price, SUM(purchase_count) AS purchase_count_sum
      FROM (
               SELECT product_name,product_price, purchase_count
               FROM purchase_order_detail JOIN product
               USING(product_id)
           )
      GROUP BY product_name,product_price
     )
ORDER BY purchase_count_sum DESC
WITH READ ONLY
;

--���i���Ə��i�݌ɂ𓯎��ɓ��邽�߂̃r���[�B
CREATE OR REPLACE VIEW product_information_view AS
SELECT product_id, product_name, product_price, product_description
       category_id, sub_category_id, product_size, product_color,
       product_release_date, product_stock_count
FROM product JOIN product_stock
     USING(product_id)
WITH READ ONLY
;

--�V�����i�𓾂邽�߂̃r���[�B�̔������V�������i���ɕ\������B
CREATE OR REPLACE VIEW new_product_view AS
SELECT *
FROM product_information_view
ORDER BY product_release_date desc,product_id
WITH READ ONLY
;

--�w�������𓾂邽�߂̃r���[�B
--���̃r���[����member_id��WHERE��őI�Ԃ��ƂŁA�����l�̍w�������𓾂邱�Ƃ��ł���B
--�g�p�p�x�����̃r���[�ɔ�ׂĒႢ�̂ŁA�쐬���Ȃ��Ă��悢�B
CREATE OR REPLACE VIEW purchase_order_detail_view AS
SELECT member_id, purchase_order_id, purchase_order_date, 
       purchase_order_delivery_status, purchase_order_detail_id
       product_id, purchase_count
FROM purchase_order JOIN purchase_order_detail
     USING(purchase_order_id)
ORDER BY purchase_order_date DESC
WITH READ ONLY
;

--01/26�ǉ�
--���O���d�����Ȃ����i�̃��X�g���擾����B
--���ۂɎg�p����̂͂���̉��̃r���[�ŁA����͎g�p���Ȃ��B
CREATE OR REPLACE VIEW product_list_view AS
SELECT product_name, product_price,
       category_id, sub_category_id,
       CURRENT_DATE + AVG( product_release_date - CURRENT_DATE ) 
       AS product_release_date, 
       SUM(product_stock_count) AS product_stock_count,
       MIN(product_id) AS example_product_id
FROM product_information_view 
GROUP BY product_name, product_price, category_id, sub_category_id
WITH READ ONLY
;

--���O���d�����Ȃ����i�̃��X�g���擾����B
CREATE OR REPLACE VIEW product_catalog_view AS
SELECT product_name, product_price,
       category_id, sub_category_id,
       product_release_date, product_stock_count,
       example_product_id, product_image_path,
       purchase_count_sum
FROM product_list_view JOIN product_image
ON(example_product_id = product_image.product_id)
JOIN purchase_ranking_view
USING(product_name,product_price)
WITH READ ONLY
;