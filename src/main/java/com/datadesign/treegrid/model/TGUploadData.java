package com.datadesign.treegrid.model;

import com.datadesign.treegrid.config.TGBooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 트리그리드 업로드 속성 필드
 * 모든 필드가 상속받을 자식클래스의 getter/setter의 영향을 주면 안되기 때문에 @Data 어노테이션 없이 직접 메소드 구현
 */
@Getter
@Setter
public class TGUploadData {
    /**  id는 TreeGrid에서 행을 제어하기 위해 쓰는 필수값으로 Def와 함께 무조건 넘어옴 */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("id")
    String id;
    /** Def는 TreeGrid에서 행을 제어하기 위해 쓰는 필수값으로 id와 함께 무조건 넘어옴 */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Def")
    String Def;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Moved")
    int Moved;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Prev")
    String Prev;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Next")
    String Next;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Copy")
    String Copy;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Selected")
    @JsonDeserialize(using = TGBooleanDeserializer.class)
    boolean Selected;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Deleted")
    @JsonDeserialize(using = TGBooleanDeserializer.class)
    boolean Deleted;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Changed")
    @JsonDeserialize(using = TGBooleanDeserializer.class)
    boolean Changed;
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonProperty("Added")
    @JsonDeserialize(using = TGBooleanDeserializer.class)
    boolean Added;

    @JsonProperty("id")
    public String getUploadId() {
        return id;
    }
    @JsonProperty("id")
    public void setUploadId(String id) {
        this.id = id;
    }
    @JsonProperty("Def")
    public String getUploadDef() {
        return Def;
    }
    @JsonProperty("Def")
    public void setUploadDef(String def) {
        this.Def = def;
    }
    @JsonProperty("Moved")
    public int getUploadMoved() {
        return Moved;
    }
    @JsonProperty("Moved")
    public void setUploadMoved(int moved) {
        this.Moved = moved;
    }
    @JsonProperty("Prev")
    public String getUploadPrev() {
        return Prev;
    }
    @JsonProperty("Prev")
    public void setUploadPrev(String prev) {
        this.Prev = prev;
    }
    @JsonProperty("Next")
    public String getUploadNext() {
        return Next;
    }
    @JsonProperty("Next")
    public void setUploadNext(String next) {
        this.Next = next;
    }
    @JsonProperty("Copy")
    public String getUploadCopy() {
        return Copy;
    }
    @JsonProperty("Copy")
    public void setUploadCopy(String copy) {
        this.Copy = copy;
    }
    @JsonProperty("Selected")
    public boolean isUploadSelected() {
        return Selected;
    }
    @JsonProperty("Selected")
    public void setUploadSelected(boolean selected) {
        this.Selected = selected;
    }
    @JsonProperty("Deleted")
    public boolean isUploadDeleted() {
        return Deleted;
    }
    @JsonProperty("Deleted")
    public void setUploadDeleted(boolean deleted) {
        this.Deleted = deleted;
    }
    @JsonProperty("Changed")
    public boolean isUploadChanged() {
        return Changed;
    }
    @JsonProperty("Changed")
    public void setUploadChanged(boolean changed) {
        this.Changed = changed;
    }
    @JsonProperty("Added")
    public boolean isUploadAdded() {
        return Added;
    }
    @JsonProperty("Added")
    public void setUploadAdded(boolean added) {
        this.Added = added;
    }

}
