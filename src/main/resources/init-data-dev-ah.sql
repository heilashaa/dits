-- Init data
INSERT INTO dits_test.role (name) VALUES ('ADMIN'), ('USER'), ('TUTOR');

INSERT INTO dits_test.user (first_name, middle_name, last_name, login, password, email, is_enabled) VALUES
('Alexandr', 'Alexandrovich', 'Heilash', 'Alexandr_H', '$2a$10$vDSVH5faQY74UeV.7RIKyuq08dOSwOPrmDKf1Tpw2Oj6dhCiWuo0q', 'alexandr.heilash@gmail.com', 1),
('Yahor', 'Sergeevich', 'Radziuk', 'Yahor_R', '$2y$12$QSb8i3iKaogmp/yDIQNygO.aagyFJGDhwKcWQz5Yq8m55ZVXDypUW', 'yahor.radziuk@gmail.com', 0),
('Aleksandr', 'Dmitrievich', 'Anashkevich', 'Aleksandr_A', '$2y$12$UP9MTW3Xk8a64vBJ7XCQP.R3RpED/.L/5gRppS0tpib8KC93SofUe', 'aleksandr.anashkevich@gmail.com', 1),
('Q', 'Q', 'Q', 'Q', '$2y$12$OhoYMgRyThvzxCt5IjecYeU.cMxwOs2CQpylcPiSsg0EGnAqt34k6', 'aleksandr.anashkevich@gmail.com', 1);

INSERT INTO dits_test.user_role (user_id, role_id) VALUES
(1, 1), (2, 2), (3, 3), (1, 2), (3, 1), (3, 2), (4, 1);

INSERT INTO dits_test.topic (description, name) VALUES
('Основы языка программирования Java','Java Core'),
('Разработка промышленных приложений','Java EE'),
('Современный фреймворк для программирования на Java','Spring Framework'),
('ORM фреймворк. Одна из реализаций JPA','Hibernate'),
('Основы объектно-ориентированного программирования','ООП');

INSERT INTO dits_test.test (name, description, topic_id) VALUES
('Типы данных','Тест по типам данных в Java', 1),
('Класс Object','Тест по классу Object', 1),
('Исключения','Тест по исключениям', 1),
('Коллекции','Тест по коллекциям в Java', 1),
('Многопоточность','Тест по многопоточности в Java', 1),
('Servlet API','Тест по Servlet API', 2),
('EJB','Тест по EJB', 2),
('IoC','Тест по IoC', 3),
('Spring Security','Тест по Spring Security', 3),
('Аннотации','Тест по аннотациям', 4),
('Cache','Тест по Cache', 4),
('Основы ООП','Тест по основам ООП', 5),
('SOLID','Тест по SOLID', 5);
