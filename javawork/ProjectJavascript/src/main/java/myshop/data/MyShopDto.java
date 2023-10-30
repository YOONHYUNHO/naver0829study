package myshop.data;

import java.sql.Timestamp;

public class MyShopDto {
  private int num;
  private String item;
  private String photo;
  private int price;
  private String color;
  private Timestamp writeDay;

  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
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
  public Timestamp getWriteDay() {
    return writeDay;
  }
  public void setWriteDay(Timestamp writeDay) {
    this.writeDay = writeDay;
  }
}
