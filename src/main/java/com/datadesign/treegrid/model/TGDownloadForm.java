package com.datadesign.treegrid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeGrid에서 데이터를 요청할때 반환하는 양식
 * T에는 표에 들어갈 데이터의 객체를 넣어야함
 * 아래와 같은 구조로 Body는 List의 List로 구성되어있음
 * 실제로 테스트 결과 List에 add하는 방식으로도 값을 전부 표출할 수 있음
 * 하지만 실제로 페이징의 경우가 아니라면 단일 List만 있어도 충분히 구현가능해서 init 메소드를 만들어 초기화시 바로 body를 List<List>에 setting 하도록 함
 * ex) Body : [ [ { A:"R1", id:"R1", Deleted:1, C:'1/1/2000' } ], [ { A:"R1", id:"R1", Deleted:1, C:'1/1/2000' }]
 * {
 * Body: [
 *          [
 *              { A:"R1", id:"R1", Deleted:1, C:'1/1/2000' },
 *              { A:"R2", id:"R2", Added:1, Items: [
 *                      { A:"R2-1", Changed:1, AChanged:1 },
 *                      { A:"R2-2", Items: [ { A:"R2-2-1", Selected:1 } ] }
 *                  ]
 *              }
 *          ],
 *          { id:'B2',Count:1 }
 *      ]
 * }
 * @param <T>
 */
@Data
public class TGDownloadForm<T> {
    @JsonProperty("Body")
    private List<List<T>> body = new ArrayList<>();

    public static <T> TGDownloadForm<T> init(List<T> rows) {
        TGDownloadForm<T> form = new TGDownloadForm<>();
        form.setBody(List.of(rows));
        return form;
    }

}
