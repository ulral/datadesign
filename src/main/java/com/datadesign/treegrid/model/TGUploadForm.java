package com.datadesign.treegrid.model;

import com.datadesign.treegrid.config.TGForm;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TreeGrid의 업로드 양식으로 아래와 같은 XML데이터를 Json타입으로 변환하기 위한 부모클래스
 * [application/x-www-form-urlencode] TreeGrid는 ActionSave를 할때, 전송 타입이 JSON문자열로 반환되기 때문에 올바르게 리플렉션이 되도록 @TGForm을 구현함
 * TGUploadData를 상속한 클래스 T만이 TGUploadForm을 지네릭으로 받을 수 있도록 구성하였고
 * 가변형 데이터의 경우 Map Type을 이용해야하는데 TGUploadData를 상속받고 있지않아서 사용할 수 없음으로 직접 Object를 형변환하거나 HashMap에 TGUploadData 상속을 구현한 TGMap을 사용할 수 있음
 * TreeGrid Document에서 설명하는 일부 속성값들을 생성해놓았으나 실제 update flag, type을 변환하면서 다양한 값들이 넘어올 수 있음. 필요에 따라 추가하면 됨
 *
 * <Grid> (Root tag, can accept any count of introduced child tags in any order)
 * <IO ... attributes with client request ... />
 * <Changes> (list of changed rows)
 * <I id='...' ... row and cell attributes ... />
 * ... More tags <I> ...
 * </Changes>
 * </Grid>
 * @param <T>
 */
@Data
@TGForm
public class TGUploadForm<T extends TGUploadData> {
    @JsonProperty("IO")
    private Map<String, Object> IO;
    @JsonProperty("Cfg")
    private Map<String, Object> Cfg;
    @JsonProperty("Changes")
    private List<T> Changes;
    @JsonProperty("Body")
    private List<List<T>> Body;
}
