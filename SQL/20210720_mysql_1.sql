INSERT INTO `procject`.`test`
(`memo`)
VALUES
('test memo2');

UPDATE `procject`.`test`
SET
`memo` = 'edit memo'
WHERE `idx` = 2;

DELETE FROM `procject`.`test`
WHERE idx=3;




