package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  long id;

  @Column(name = "model")
  String model;

  @Column(name = "series")
  int series;

  public Car() {
  }

  public Car(String model, int series) {
    this.model = model;
    this.series = series;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getSeries() {
    return series;
  }

  public void setSeries(int series) {
    this.series = series;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", model='" + model + '\'' +
        ", series=" + series +
        '}';
  }
}
