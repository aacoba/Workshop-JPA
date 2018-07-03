CREATE TABLE audit_trail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  sale_id BIGINT NOT NULL,
  account_id BIGINT NOT NULL,

  constraint pk_audit_trail PRIMARY KEY (id)
);