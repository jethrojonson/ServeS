--ALLERGENS--
INSERT INTO ALLERGENS (ID, ALLERGEN_NAME, DESCRIPTION) VALUES
    (10001, 'Gluten', 'Cereales con gluten'),
    (10002, 'Crustáceos', 'Crustáceos y productos a base de custáceos'),
    (10003, 'Huevo', 'Puede contener trazas de huevo'),
    (10004, 'Pescado', 'Pescado y productos a base de pescados'),
    (10005, 'Cacahuetes', 'Cacahuetes, productos a base de cacahuetes y frutos secos'),
    (10006, 'Soja', 'Soja y productos a base de soja'),
    (10007, 'Lácteos', 'Leche y sus derivados (incluida la lactosa)'),
    (10008, 'Frutos con cáscara', 'Frutos de cáscara y productos derivados'),
    (10009, 'Apio', 'Apio y productos derivados'),
    (10010, 'Mostaza', 'Mostaza y productos a base de mostaza'),
    (10011, 'Sésamo', 'Granos o semillas de sésamo y productos a base de sésamo'),
    (10012, 'Sulfitos', 'Dióxido de azufre y sulfitos'),
    (10013, 'Altramuces', 'Altramuces y productos a base de altramuces'),
    (10014, 'Moluscos', 'Moluscos y crustáceos y productos a base de estos');

--ADMINS
INSERT INTO USERS (ID, EMAIL, USERNAME, PASSWORD, ROLES, LAST_PASSWORD_CHANGE_AT, CREATED_AT, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED) VALUES
    ('101128c3-061e-4987-afc8-55e00b277d8a', 'admin1@email.com', 'admin1', '{bcrypt}$2a$12$ENX6ez7srOFSkW2jj6ON..mR8P67jZcWIjYfS57x1y8rRQsKqTuRW', 'ADMIN', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE);
    INSERT INTO ADMINISTRATORS (ID) VALUES
        ('101128c3-061e-4987-afc8-55e00b277d8a');

--CUSTOMERS
INSERT INTO USERS (ID, EMAIL, USERNAME, PASSWORD, ROLES, LAST_PASSWORD_CHANGE_AT, CREATED_AT, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED) VALUES
    ('5643caf4-571b-4dae-8b8a-8a7289560785', 'xopin@gmail.com', 'bolon_xopin', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('319e1891-371b-4fb5-9001-4c845301d1cd', 'antonio@outlook.com', 'barrox', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('614a0f13-753c-4e1f-b455-c4677435a74f', 'carlos@email.com', 'durbaneitor', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('c26fc940-a409-417c-9509-20e9d8089f4b', 'niko.culo@hotmail.es', 'niko_culo', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('d194ceb2-478b-43e9-8eb4-434de180b666', 'maylor_rrpp@gmail.com', 'shu_maylor', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE);
    INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, SURNAME, CUSTOMER_AVATAR) VALUES
        ('5643caf4-571b-4dae-8b8a-8a7289560785', 'Xopin', 'Chollez', 'xopin-avatar.jpg'),
        ('319e1891-371b-4fb5-9001-4c845301d1cd', 'Antonio', 'Skatez', 'antonio-avatar.jpg'),
        ('614a0f13-753c-4e1f-b455-c4677435a74f', 'Durban', 'Abuelez', 'durban-avatar.jpg'),
        ('c26fc940-a409-417c-9509-20e9d8089f4b', 'Nikolai', 'Chauchescu', 'nikolai-avatar.jpg'),
        ('d194ceb2-478b-43e9-8eb4-434de180b666', 'Gaylord', 'Sudakez', 'gaylord-avatar.jpg');

--COMPANIES
INSERT INTO USERS (ID, EMAIL, USERNAME, PASSWORD, ROLES, LAST_PASSWORD_CHANGE_AT, CREATED_AT, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED) VALUES
    ('2f3cf089-ed3c-4955-89bd-441bd3971167', 'gomez@email.com', 'gomez-industries-SL', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('994eb816-fec4-4ed6-9fc8-4cf5638e5dd2', 'jose@email.com', 'pepe&co', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('97527e90-5b8d-42df-b049-688ea7d95563', 'arturo.sanchez@email.com', 'santo-tomas', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('f5972f6b-c6e1-497e-9a9a-f69e62e6c557', 'will_edward@email.com', 'breakfast-SA', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('2d08a0dc-c472-4a3e-9628-1dd23e446b5b', 'cam1987@email.com', 'beer&entertainment', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE);
    INSERT INTO COMPANIES (COMPANY_ID, COMPANY_NAME, CIF, COMPANY_AVATAR) VALUES
        ('2f3cf089-ed3c-4955-89bd-441bd3971167', 'Dinner_Bagdad','R1360108C', 'dinner-bagdag.jpg'),
        ('994eb816-fec4-4ed6-9fc8-4cf5638e5dd2', 'Bar_Pepe', 'B01467596', 'bar-pepe.jpg'),
        ('97527e90-5b8d-42df-b049-688ea7d95563', 'Santo_Tomas_Panadería', 'R2191313B', 'santo-tomas-panaderia.jpg'),
        ('f5972f6b-c6e1-497e-9a9a-f69e62e6c557', 'Maid_cafe','H48869317', 'maid-cafe.jpg'),
        ('2d08a0dc-c472-4a3e-9628-1dd23e446b5b', 'Monasterio_Drinks','B26820084', 'monasterio-drinks.jpg');

--CATEGORIES
INSERT INTO CATEGORIES (ID, CATEGORY_NAME, COMPANY_ID) VALUES
    (10001, 'Bebidas', '2f3cf089-ed3c-4955-89bd-441bd3971167'),
    (10002, 'Bebidas Alcoholicas', '2f3cf089-ed3c-4955-89bd-441bd3971167'),
    (10003, 'Carne', '2f3cf089-ed3c-4955-89bd-441bd3971167'),
    (10004, 'Pescado', '2f3cf089-ed3c-4955-89bd-441bd3971167'),
    (10005, 'Enasalada', '2f3cf089-ed3c-4955-89bd-441bd3971167');


--PRODUCTS
INSERT INTO PRODUCTS (ID, PRODUCT_NAME, COMPANY_ID, ACTIVE) VALUES
    (10001, 'Fanta 20cl', '2f3cf089-ed3c-4955-89bd-441bd3971167', TRUE),
    (10002, 'Alhambra 1925 33cl', '2f3cf089-ed3c-4955-89bd-441bd3971167', TRUE),
    (10003, 'Solomillo al Whiskey', '2f3cf089-ed3c-4955-89bd-441bd3971167', TRUE),
    (10004, 'Dorada al horno', '2f3cf089-ed3c-4955-89bd-441bd3971167', TRUE),
    (10005, 'Ensalada César', '2f3cf089-ed3c-4955-89bd-441bd3971167', TRUE);