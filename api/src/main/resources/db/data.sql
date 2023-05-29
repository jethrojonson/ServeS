--ALLERGENS--
INSERT INTO ALLERGENS (ID, ALLERGEN_NAME, DESCRIPTION) VALUES
    (NEXTVAL('hibernate_sequence'), 'Gluten', 'Cereales con gluten'),
    (NEXTVAL('hibernate_sequence'), 'Crustáceos', 'Crustáceos y productos a base de custáceos'),
    (NEXTVAL('hibernate_sequence'), 'Huevo', 'Puede contener trazas de huevo'),
    (NEXTVAL('hibernate_sequence'), 'Pescado', 'Pescado y productos a base de pescados'),
    (NEXTVAL('hibernate_sequence'), 'Cacahuetes', 'Cacahuetes, productos a base de cacahuetes y frutos secos'),
    (NEXTVAL('hibernate_sequence'), 'Soja', 'Soja y productos a base de soja'),
    (NEXTVAL('hibernate_sequence'), 'Lácteos', 'Leche y sus derivados (incluida la lactosa)'),
    (NEXTVAL('hibernate_sequence'), 'Frutos con cáscara', 'Frutos de cáscara y productos derivados'),
    (NEXTVAL('hibernate_sequence'), 'Apio', 'Apio y productos derivados'),
    (NEXTVAL('hibernate_sequence'), 'Mostaza', 'Mostaza y productos a base de mostaza'),
    (NEXTVAL('hibernate_sequence'), 'Sésamo', 'Granos o semillas de sésamo y productos a base de sésamo'),
    (NEXTVAL('hibernate_sequence'), 'Sulfitos', 'Dióxido de azufre y sulfitos'),
    (NEXTVAL('hibernate_sequence'), 'Altramuces', 'Altramuces y productos a base de altramuces'),
    (NEXTVAL('hibernate_sequence'), 'Moluscos', 'Moluscos y crustáceos y productos a base de estos');

--CUSTOMERS
INSERT INTO USERS (ID, EMAIL, USERNAME, PASSWORD, ROLES, LAST_PASSWORD_CHANGE_AT, CREATED_AT, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED) VALUES
    ('5643caf4-571b-4dae-8b8a-8a7289560785', 'customer1@email.com', 'customer1', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('319e1891-371b-4fb5-9001-4c845301d1cd', 'customer2@email.com', 'customer2', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('614a0f13-753c-4e1f-b455-c4677435a74f', 'customer3@email.com', 'customer3', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('c26fc940-a409-417c-9509-20e9d8089f4b', 'customer4@email.com', 'customer4', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('d194ceb2-478b-43e9-8eb4-434de180b666', 'customer5@email.com', 'customer5', '{bcrypt}$2a$12$kND3w8e/Ui7Ay4K3mD.2fujdJhfJx7tlBKAUP.Iza7HYxm/eGrRGS', 'CUSTOMER', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE);
    INSERT INTO CUSTOMERS (CUSTOMER_ID, NAME, SURNAME, CUSTOMER_AVATAR) VALUES
        ('5643caf4-571b-4dae-8b8a-8a7289560785', 'Xopin', 'Chollez', 'xopin-avatar.jpg'),
        ('319e1891-371b-4fb5-9001-4c845301d1cd', 'Antonio', 'Skatez', 'antonio-avatar.jpg'),
        ('614a0f13-753c-4e1f-b455-c4677435a74f', 'Durban', 'Abuelez', 'durban-avatar.jpg'),
        ('c26fc940-a409-417c-9509-20e9d8089f4b', 'Nikolai', 'Chauchescu', 'nikolai-avatar.jpg'),
        ('d194ceb2-478b-43e9-8eb4-434de180b666', 'Gaylord', 'Sudakez', 'gaylord-avatar.jpg');

--COMPANIES
INSERT INTO USERS (ID, EMAIL, USERNAME, PASSWORD, ROLES, LAST_PASSWORD_CHANGE_AT, CREATED_AT, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED) VALUES
    ('2f3cf089-ed3c-4955-89bd-441bd3971167', 'company1@email.com', 'company1', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('994eb816-fec4-4ed6-9fc8-4cf5638e5dd2', 'company2@email.com', 'company2', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('97527e90-5b8d-42df-b049-688ea7d95563', 'company3@email.com', 'company3', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('f5972f6b-c6e1-497e-9a9a-f69e62e6c557', 'company4@email.com', 'company4', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE),
    ('2d08a0dc-c472-4a3e-9628-1dd23e446b5b', 'company5@email.com', 'company5', '{bcrypt}$2a$12$0/kkHcTISLk66M0VXGqqWek4OyL/wJf1xNzTsi0dd5nAXhKashkae', 'COMPANY', current_timestamp, current_timestamp, TRUE, TRUE, TRUE, TRUE);
    INSERT INTO COMPANIES (COMPANY_ID, COMPANY_NAME, CIF, COMPANY_AVATAR) VALUES
        ('2f3cf089-ed3c-4955-89bd-441bd3971167', 'CHOLLO-APP','R1360108C', 'chollo-app.jpg'),
        ('994eb816-fec4-4ed6-9fc8-4cf5638e5dd2', 'Social-rides', 'B01467596', 'social-rides.jpg'),
        ('97527e90-5b8d-42df-b049-688ea7d95563', 'Resiencia Viejunos', 'R2191313B', 'residencia-viejunos.jpg'),
        ('f5972f6b-c6e1-497e-9a9a-f69e62e6c557', 'Full Hentai SL','H48869317', 'full-hentai-sl.jpg'),
        ('2d08a0dc-c472-4a3e-9628-1dd23e446b5b', 'Cocaine International','B26820084', 'cocaine-international.jpg');


