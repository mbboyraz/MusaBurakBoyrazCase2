package mbb.com;

public class Category {
    private String titleCategory;

    public Category(String titleCategory) {                 //category class constructor only category title
        this.titleCategory = titleCategory;
    }

    public Category() {
    }

    public String getTitleCategory() {
        return titleCategory;
    }

    public void setTitleCategory(String titleCategory) {
        this.titleCategory = titleCategory;
    }
}
