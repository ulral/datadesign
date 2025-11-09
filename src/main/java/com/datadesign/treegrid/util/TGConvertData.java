package com.datadesign.treegrid.util;

import com.datadesign.grid.model.DataAttrItem;
import com.datadesign.grid.model.GridAttrItem;

import java.util.*;

/**
 * TreeGrid Layout을 그리기 위한 데이터 변환 메소드
 */
public class TGConvertData {
    /**
     * TreeGrid Config속성에 맞는 데이터 타입으로 변환하는 메소드
     * ※ Config속성은 Key-Value 구조로만 구성됨
     * @param items
     * @return
     */
    public static Map<String, Map<String, Object>> convertToGroupedMap(List<GridAttrItem> items) {
        Map<String, Map<String, Object>> result = new LinkedHashMap<>();

        for (GridAttrItem item : items) {
            String attr = item.getAttrSn().getAttr();   // 예: "Toolbar", "Panel"
            String key = item.getAttrItem();            // 예: "id", "Visible"
            String value = item.getAttrValue();         // 예: "Toolbar", "1"

            // ATTR 기준으로 그룹핑
            Map<String, Object> group = result.computeIfAbsent(attr, k -> new LinkedHashMap<>());

            // 값 파싱 (숫자면 숫자로, 아니면 문자열로)
            group.put(key, parseValue(value));
        }

        return result;
    }

    /**
     * TreeGrid Column속성에 맞는 데이터 타입으로 변환하는 메소드
     * ※ Column속성은 Key-Value 구조의 List로 구성됨
     * @param items
     * @return
     */
    public static Map<String, List<Map<String, Object>>> convertGridDataItems(List<DataAttrItem> items) {
        Map<String, Map<Integer, Map<String, Object>>> grouped = new LinkedHashMap<>();

        for (DataAttrItem item : items) {
            String attr = item.getAttrSn().getAttr();   // 예: "Cols", "Head"
            Integer row = item.getAttrRow();            // 예: 1, 2, 3...
            String key = item.getAttrItem();            // 예: "Name", "Kind", "SN"
            String value = item.getAttrValue();         // 예: "SN", "시퀀스"

            grouped
                    .computeIfAbsent(attr, k -> new TreeMap<>()) // ATTR 기준 그룹핑
                    .computeIfAbsent(row, r -> new LinkedHashMap<>()) // ATTR_ROW 기준 병합
                    .put(key, parseValue(value));
        }

        // 최종 구조: Map<String, List<Map<String, Object>>>
        Map<String, List<Map<String, Object>>> result = new LinkedHashMap<>();
        for (Map.Entry<String, Map<Integer, Map<String, Object>>> entry : grouped.entrySet()) {
            result.put(entry.getKey(), new ArrayList<>(entry.getValue().values()));
        }

        return result;
    }

    /**
     * TreeGrid Config속성과 Column속성을 합쳐서 Layout을 완성시키는 메소드
     * @param grouped
     * @param layout
     * @return
     */
    public static Map<String, Object> mergeGridLayout(
            Map<String, Map<String, Object>> grouped,
            Map<String, List<Map<String, Object>>> layout
    ) {
        Map<String, Object> result = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Object>> entry : grouped.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, List<Map<String, Object>>> entry : layout.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static Object parseValue(String value) {
        if (value == null || value.trim().isEmpty()) return "";
        try {
            if (value.contains(".")) return Double.parseDouble(value);
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return value;
        }
    }
}
