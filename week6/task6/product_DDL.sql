CREATE TABLE product_category(
  category_id SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '分类ID',
  category_name VARCHAR(10) NOT NULL COMMENT '分类名称',
  category_code VARCHAR(10) NOT NULL COMMENT '分类编码',
  parent_id SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父分类ID',
  category_level TINYINT NOT NULL DEFAULT 1 COMMENT '分类层级',
  category_status TINYINT NOT NULL DEFAULT 1 COMMENT '分类状态',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '最后修改时间',
  PRIMARY KEY pk_categoryid(category_id)
)ENGINE=innodb COMMENT '商品分类表';

CREATE TABLE supplier_info(
  supplier_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '供应商ID',
  supplier_code CHAR(8) NOT NULL COMMENT '供应商编码',
  supplier_name CHAR(50) NOT NULL COMMENT '供应商名称',
  supplier_type TINYINT NOT NULL COMMENT '供应商类型：1.自营，2.平台',
  link_man VARCHAR(10) NOT NULL COMMENT '供应商联系人',
  phone_number VARCHAR(50) NOT NULL COMMENT '联系电话',
  bank_name VARCHAR(50) NOT NULL COMMENT '供应商开户银行名称',
  bank_account VARCHAR(50) NOT NULL COMMENT '银行账号',
  address VARCHAR(200) NOT NULL COMMENT '供应商地址',
  supplier_status TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0禁止，1启用',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '最后修改时间',
  PRIMARY KEY pk_supplierid(supplier_id)
) ENGINE = innodb COMMENT '供应商信息表';

CREATE TABLE product_info(
  product_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
  product_core CHAR(16) NOT NULL COMMENT '商品编码',
  product_name VARCHAR(20) NOT NULL COMMENT '商品名称',
  bar_code VARCHAR(50) NOT NULL COMMENT '国条码',
  brand_id INT UNSIGNED NOT NULL COMMENT '品牌表的ID',
  one_category_id SMALLINT UNSIGNED NOT NULL COMMENT '一级分类ID',
  two_category_id SMALLINT UNSIGNED NOT NULL COMMENT '二级分类ID',
  three_category_id SMALLINT UNSIGNED NOT NULL COMMENT '三级分类ID',
  supplier_id INT UNSIGNED NOT NULL COMMENT '商品的供应商ID',
  price DECIMAL(8,2) NOT NULL COMMENT '商品销售价格',
  average_cost DECIMAL(18,2) NOT NULL COMMENT '商品加权平均成本',
  publish_status TINYINT NOT NULL DEFAULT 0 COMMENT '上下架状态：0下架1上架',
  audit_status TINYINT NOT NULL DEFAULT 0 COMMENT '审核状态：0未审核，1已审核',
  weight FLOAT COMMENT '商品重量',
  length FLOAT COMMENT '商品长度',
  height FLOAT COMMENT '商品高度',
  width FLOAT COMMENT '商品宽度',
  color_type ENUM('红','黄','蓝','黑'),
  production_date DATETIME NOT NULL COMMENT '生产日期',
  shelf_life INT NOT NULL COMMENT '商品有效期',
  descript TEXT NOT NULL COMMENT '商品描述',
  indate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品录入时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_productid(product_id)
) ENGINE = innodb COMMENT '商品信息表';

CREATE TABLE product_pic_info(
  product_pic_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品图片ID',
  product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
  pic_desc VARCHAR(50) COMMENT '图片描述',
  pic_url VARCHAR(200) NOT NULL COMMENT '图片URL',
  is_master TINYINT NOT NULL DEFAULT 0 COMMENT '是否主图：0.非主图1.主图',
  pic_order TINYINT NOT NULL DEFAULT 0 COMMENT '图片排序',
  pic_status TINYINT NOT NULL DEFAULT 1 COMMENT '图片是否有效：0无效 1有效',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '最后修改时间',
  PRIMARY KEY pk_picid(product_pic_id)
)ENGINE=innodb COMMENT '商品图片信息表';

CREATE TABLE product_comment(
  comment_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '评论ID',
  product_id INT UNSIGNED NOT NULL COMMENT '商品ID',
  order_id BIGINT UNSIGNED NOT NULL COMMENT '订单ID',
  customer_id INT UNSIGNED NOT NULL COMMENT '用户ID',
  title VARCHAR(50) NOT NULL COMMENT '评论标题',
  content VARCHAR(300) NOT NULL COMMENT '评论内容',
  audit_status TINYINT NOT NULL COMMENT '审核状态：0未审核，1已审核',
  audit_time TIMESTAMP NOT NULL COMMENT '评论时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_commentid(comment_id)
) ENGINE = innodb COMMENT '商品评论表';