package OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop {
    @Id
    private int id;
    private String brand;
    private String model;

    public Laptop() {
    }

    public Laptop(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }
    
    

    public void setId(int id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Laptop [id=" + id + ", brand=" + brand + ", model=" + model + "]";
    }
}
