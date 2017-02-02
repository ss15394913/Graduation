--購入数ランキングを得るためのビュー。購入個数が多い商品を先に表示する。
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

--商品情報と商品在庫を同時に得るためのビュー。
CREATE OR REPLACE VIEW product_information_view AS
SELECT product_id, product_name, product_price, product_description
       category_id, sub_category_id, product_size, product_color,
       product_release_date, product_stock_count
FROM product JOIN product_stock
     USING(product_id)
WITH READ ONLY
;

--新着商品を得るためのビュー。販売日が新しい商品を先に表示する。
CREATE OR REPLACE VIEW new_product_view AS
SELECT *
FROM product_information_view
ORDER BY product_release_date desc,product_id
WITH READ ONLY
;

--購入履歴を得るためのビュー。
--このビューからmember_idをWHERE句で選ぶことで、会員一人の購入履歴を得ることができる。
--使用頻度が他のビューに比べて低いので、作成しなくてもよい。
CREATE OR REPLACE VIEW purchase_order_detail_view AS
SELECT member_id, purchase_order_id, purchase_order_date, 
       purchase_order_delivery_status, purchase_order_detail_id
       product_id, purchase_count
FROM purchase_order JOIN purchase_order_detail
     USING(purchase_order_id)
ORDER BY purchase_order_date DESC
WITH READ ONLY
;

--01/26追加
--名前が重複しない商品のリストを取得する。
--実際に使用するのはこれの下のビューで、これは使用しない。
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

--名前が重複しない商品のリストを取得する。
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