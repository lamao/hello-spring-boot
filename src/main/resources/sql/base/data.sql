insert into property_definition (id, code) values
(UUID(), 'description'),
(UUID(), 'value');

insert into entity_type (id, code) values
(UUID(), 'GAME'),
(UUID(), 'LOCATION');

insert into entity (id, type_id) values
(UUID(), (select id from entity_type where code = 'GAME')),
(UUID(), (select id from entity_type where code = 'LOCATION')),
(UUID(), (select id from entity_type where code = 'LOCATION'));