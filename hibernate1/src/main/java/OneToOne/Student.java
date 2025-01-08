package OneToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="id")
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="laptop_id")
    private Laptop laptop;

    public Student() {
    }

    public Student(int id, String name, Laptop laptop) {
        this.id = id;
        this.name = name;
        this.laptop = laptop;
    }
    

    public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", laptop=" + laptop + "]";
    }
}