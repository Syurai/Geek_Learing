CREATE TABLE customer_login(
  customer_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '用户ID',
  login_name VARCHAR(20) NOT NULL COMMENT '用户登录名',
  password CHAR(32) NOT NULL COMMENT 'md5加密的密码',
  user_stats TINYINT NOT NULL DEFAULT 1 COMMENT '用户状态',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_customerid(customer_id)
) ENGINE = innodb COMMENT '用户登录表';

CREATE TABLE customer_inf(
  customer_inf_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  customer_id INT UNSIGNED NOT NULL COMMENT 'customer_login表的自增ID',
  customer_name VARCHAR(20) NOT NULL COMMENT '用户真实姓名',
  identity_card_type TINYINT NOT NULL DEFAULT 1 COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  identity_card_no VARCHAR(20) COMMENT '证件号码',
  mobile_phone INT UNSIGNED COMMENT '手机号',
  customer_email VARCHAR(50) COMMENT '邮箱',
  gender CHAR(1) COMMENT '性别',
  user_point INT NOT NULL DEFAULT 0 COMMENT '用户积分',
  register_time TIMESTAMP NOT NULL COMMENT '注册时间',
  birthday DATETIME COMMENT '会员生日',
  customer_level TINYINT NOT NULL DEFAULT 1 COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  user_money DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '用户余额',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_customerinfid(customer_inf_id)
) ENGINE = innodb COMMENT '用户信息表';

CREATE TABLE customer_addr(
  customer_addr_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  customer_id INT UNSIGNED NOT NULL COMMENT 'customer_login表的自增ID',
  zip SMALLINT NOT NULL COMMENT '邮编',
  province SMALLINT NOT NULL COMMENT '地区表中省份的ID',
  city SMALLINT NOT NULL COMMENT '地区表中城市的ID',
  district SMALLINT NOT NULL COMMENT '地区表中的区ID',
  address VARCHAR(200) NOT NULL COMMENT '具体的地址门牌号',
  is_default TINYINT NOT NULL COMMENT '是否默认',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_customeraddid(customer_addr_id)
) ENGINE = innodb COMMENT '用户地址表';

CREATE TABLE customer_balance_log(
  balance_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '余额日志ID',
  customer_id INT UNSIGNED NOT NULL COMMENT '用户ID',
  source TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '记录来源：1订单，2退货单',
  source_sn INT UNSIGNED NOT NULL COMMENT '相关单据ID',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  amount DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '变动金额',
  PRIMARY KEY pk_balanceid(balance_id)
) ENGINE = innodb COMMENT '用户余额变动表';

