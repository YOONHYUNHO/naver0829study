package data;

public class ShopDto {
  private String item;
  private String photo;
  private int price;
  private String color;

  // 디폴트 생성자
  public ShopDto() {
    super();
  }

  public ShopDto(String item, String photo, int price, String color) {
    super();
    this.item = item;
    this.photo = photo;
    this.price = price;
    this.color = color;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }




}
