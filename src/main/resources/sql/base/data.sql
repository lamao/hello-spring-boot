insert into entity_type (id, code) values
(1, 'GAME'),
(2, 'LOCATION');

insert into entity (id, type_id) values
(1, 1),
(2, 2),
(3, 2);

insert into property_definition (id, code, entity_type_id) values
(1, 'name', 1),
(2, 'description', 1),
(3, 'x', 2),
(4, 'y', 2);

insert into property (id, value, entity_id, definition_id) values
(1, 'Big Game', 1, 1),
(2, 'This is some small game', 1, 2),
(3, '1', 2, 3),
(4, '2', 2, 4),
(5, '3', 3, 3),
(6, '1', 3, 4);