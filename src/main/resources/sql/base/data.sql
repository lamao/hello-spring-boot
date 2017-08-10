insert into entity_type (id, code) values
(UUID(), 'GAME'),
(UUID(), 'LOCATION');

insert into entity (id, type_id) values
(UUID(), (select id from entity_type where code = 'GAME')),
(UUID(), (select id from entity_type where code = 'LOCATION')),
(UUID(), (select id from entity_type where code = 'LOCATION'));

insert into property_definition (id, code, entity_type_id) values
(UUID(), 'name',        (select id from entity_type where code = 'GAME')),
(UUID(), 'description', (select id from entity_type where code = 'GAME')),
(UUID(), 'x',           (select id from entity_type where code = 'LOCATION')),
(UUID(), 'y',           (select id from entity_type where code = 'LOCATION'));