INSERT INTO tbl_invoices (number_invoice, description, customer_id, created_at, state) VALUES
('0001', 'invoice office items', 1, NOW(),'CREATED');

INSERT INTO tbl_invoice_items ( invoice_id,product_id, quantity, price ) VALUES(1, 1 , 1, 178.89);
INSERT INTO tbl_invoice_items ( invoice_id,product_id, quantity, price)  VALUES(1, 2 , 2, 12.5);
INSERT INTO tbl_invoice_items ( invoice_id,product_id, quantity, price)  VALUES(1, 3 , 1, 40.06);
INSERT INTO tbl_invoice_items ( invoice_id,product_id, quantity, price)  VALUES(1, 4 , 3, 50.06);

INSERT INTO tbl_invoices (number_invoice, description, customer_id, created_at, state) VALUES
('0002', 'invoice office items', 1, NOW(),'CREATED');

INSERT INTO tbl_invoice_items ( invoice_id, product_id, quantity, price ) VALUES( 2, 1, 2 ,178.89);
INSERT INTO tbl_invoice_items ( invoice_id, product_id, quantity, price)  VALUES( 2, 2, 3 ,12.5);

