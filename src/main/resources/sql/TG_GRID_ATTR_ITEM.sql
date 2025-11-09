INSERT INTO TG_GRID_ATTR_ITEM (SN, ATTR_SN, ATTR_ITEM, ATTR_VALUE, USE_YN)
VALUES
    (1, 1, 'SafeCSS', '1', 'Y'),
    (2, 1, 'Style', 'Standard', 'Y'),
    (3, 2, 'id', 'Toolbar', 'Y'),
    (4, 2, 'Visible', '1', 'Y'),
    (5, 2, 'Space', '-1', 'Y'),
    (6, 2, 'Tag', '', 'Y'),
    (7, 2, 'CanHide', '0', 'Y'),
    (8, 2, 'SaveButton', 'Class', 'Y'),
    (9, 2, 'ExportPDFButton', 'Class', 'Y'),
    (10, 2, 'ExportButton', 'Class', 'Y'),
    (11, 3, 'Visible', '1', 'Y'),
    (12, 4, 'Style', 'Black', 'Y');
ALTER TABLE TG_GRID_ATTR_ITEM ALTER COLUMN SN RESTART WITH 13;