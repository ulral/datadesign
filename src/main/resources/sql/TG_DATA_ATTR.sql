INSERT INTO TG_DATA_ATTR (SN, DATA_SN, ATTR, USE_YN)
VALUES
    (1, 1, 'Cols', 'Y'),
    (2, 1, 'Head', 'Y'),
    (3, 2, 'Cols', 'Y'),
    (4, 2, 'Head', 'Y'),
    (5, 3, 'Cols', 'Y'),
    (6, 3, 'Head', 'Y'),
    (7, 4, 'Cols', 'Y'),
    (8, 4, 'Head', 'Y'),
    (9, 5, 'Cols', 'Y'),
    (10, 5, 'Head', 'Y'),
    (11, 6, 'Cols', 'Y'),
    (12, 6, 'Head', 'Y');
ALTER TABLE TG_DATA_ATTR ALTER COLUMN SN RESTART WITH 13;