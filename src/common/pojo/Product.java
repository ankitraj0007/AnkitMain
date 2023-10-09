package common.pojo;

//implements Comparable and override compareTo. this is used for sorting
public class Product implements Comparable<Product>{

    private Integer productId;
    private String productName;

    @Override
    public int compareTo(Product product) {
        //delegating compare to integer natural compare
//        return productId.compareTo(product.productId);
        //or
        return this.productId - product.productId;
    }

    public Product(Integer productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
