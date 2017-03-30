
package parato.tracker.pojo.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("size")
    @Expose
    private Long size;
    @SerializedName("totalElements")
    @Expose
    private Long totalElements;
    @SerializedName("totalPages")
    @Expose
    private Long totalPages;
    @SerializedName("number")
    @Expose
    private Long number;

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

}
