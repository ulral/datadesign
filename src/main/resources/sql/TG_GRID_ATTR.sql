INSERT INTO TG_GRID_ATTR (SN, GRID_SN, ATTR, USE_YN)
VALUES
    (1, 1, 'Cfg', 'Y'),
    (2, 1, 'Toolbar', 'Y'),
    (3, 1, 'Panel', 'Y'),
    (4, 2, 'Cfg', 'Y'),
    (5, 1, 'IO', 'Y');
ALTER TABLE TG_GRID_ATTR ALTER COLUMN SN RESTART WITH 6;