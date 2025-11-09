INSERT INTO TG_DATA (SN, DATA, NAME, USE_YN)
VALUES
    (1, 'TG_GRID', '그리드', 'Y'),
    (2, 'TG_GRID_ATTR', '그리드 속성', 'Y'),
    (3, 'TG_GRID_ATTR_ITEM', '그리드 속성 아이템', 'Y'),
    (4, 'TG_DATA', '데이터', 'Y'),
    (5, 'TG_DATA_ATTR', '데이터 속성', 'Y'),
    (6, 'TG_DATA_ATTR_ITEM', '데이터 아이템', 'Y');
ALTER TABLE TG_DATA ALTER COLUMN SN RESTART WITH 7;