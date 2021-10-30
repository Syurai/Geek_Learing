CREATE TABLE order_master(
  order_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  order_sn BIGINT UNSIGNED NOT NULL COMMENT '订单编号 yyyymmddnnnnnnnn',
  customer_id INT UNSIGNED NOT NULL COMMENT '下单人ID',
  shipping_user VARCHAR(10) NOT NULL COMMENT '收货人姓名',
  province SMALLINT NOT NULL COMMENT '省',
  city SMALLINT NOT NULL COMMENT '市',
  district SMALLINT NOT NULL COMMENT '区',
  address VARCHAR(100) NOT NULL COMMENT '地址',
  payment_method TINYINT NOT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
  order_money DECIMAL(8,2) NOT NULL COMMENT '订单金额',
  district_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '优惠金额',
  shipping_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '运费金额',
  payment_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '支付金额',
  shipping_comp_name VARCHAR(10) COMMENT '快递公司名称',
  shipping_sn VARCHAR(50) COMMENT '快递单号',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  shipping_time DATETIME COMMENT '发货时间',
  pay_time DATETIME COMMENT '支付时间',
  receive_time DATETIME COMMENT '收货时间',
  order_status TINYINT NOT NULL DEFAULT 0 COMMENT '订单状态',
  order_point INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单积分',
  invoice_time VARCHAR(100) COMMENT '发票抬头',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_orderid(order_id)
)ENGINE = innodb COMMENT '订单主表';

CREATE TABLE order_detail(
  order_detail_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单详情表ID',
  order_id INT UNSIGNED NOT NULL COMMENT '订单表ID',
  product_id INT UNSIGNED NOT NULL COMMENT '订单商品ID',
  product_name VARCHAR(50) NOT NULL COMMENT '商品名称',
  product_cnt INT NOT NULL DEFAULT 1 COMMENT '购买商品数量',
  product_price DECIMAL(8,2) NOT NULL COMMENT '购买商品单价',
  average_cost DECIMAL(8,2) NOT NULL COMMENT '平均成本价格',
  weight FLOAT COMMENT '商品重量',
  fee_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '优惠分摊金额',
  w_id INT UNSIGNED NOT NULL COMMENT '仓库ID',
    modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_orderdetailid(order_detail_id)
)ENGINE = innodb COMMENT '订单详情表';

CREATE TABLE order_cart(
  cart_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  customer_id INT UNSIGNED NOT NULL COMMENT '用户ID',
  product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
  product_amount INT NOT NULL COMMENT '加入购物车商品数量',
  price DECIMAL(8,2) NOT NULL COMMENT '商品价格',
  add_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加入购物车时间',
      modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_cartid(cart_id)
) ENGINE = innodb COMMENT '购物车表';

CREATE TABLE warehouse_info(
  w_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '仓库ID',
  warehouse_sn CHAR(5) NOT NULL COMMENT '仓库编码',
  warehoust_name VARCHAR(10) NOT NULL COMMENT '仓库名称',
  warehouse_phone VARCHAR(20) NOT NULL COMMENT '仓库电话',
  contact VARCHAR(10) NOT NULL COMMENT '仓库联系人',
  province SMALLINT NOT NULL COMMENT '省',
  city SMALLINT NOT NULL COMMENT '市',
  distrct SMALLINT NOT NULL COMMENT '区',
  address VARCHAR(100) NOT NULL COMMENT '仓库地址',
  warehouse_status TINYINT NOT NULL DEFAULT 1 COMMENT '仓库状态：0禁用，1启用',
        modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_wid(w_id)
)ENGINE = innodb COMMENT '仓库信息表';

CREATE TABLE warehouse_product(
  wp_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
  w_id SMALLINT UNSIGNED NOT NULL COMMENT '仓库ID',
  current_cnt INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前商品数量',
  lock_cnt INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '当前占用数据',
  in_transit_cnt INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '在途数据',
  average_cost DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '移动加权成本',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_wpid(wp_id)
)ENGINE = innodb COMMENT '商品库存表';

CREATE TABLE shipping_info(
  ship_id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  ship_name VARCHAR(20) NOT NULL COMMENT '物流公司名称',
  ship_contact VARCHAR(20) NOT NULL COMMENT '物流公司联系人',
  telephone VARCHAR(20) NOT NULL COMMENT '物流公司联系电话',
  price DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '配送价格',
    modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_shipid(ship_id)
)ENGINE = innodb COMMENT '物流公司信息表';