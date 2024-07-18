package phuong.codeview.vn.employeemanage.entity;

import jakarta.persistence.*;

    @Entity
    @Table(name = "food")
    public class Food {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
//        @ManyToOne
//        @JoinColumn(name = "id")
//        private Category category;
        @Column(name = "Name")
        private String name;
        @Column(name = "Image")
        private String image;
        @Column(name = "Description ")
        private String description;
        @Column(name = "Quantity")
        private int quantity;
        @Column(name = "Price")
        private double price;

        public Food() {

        }

        public Food(int id, int categoryId, String name, String image, String description, int quantity, double price) {
            this.id = id;
//            this.categoryId = categoryId;
            this.name = name;
            this.image = image;
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }

        public Food(int categoryId, String name, String image, String description, int quantity, double price) {
//            this.categoryId = categoryId;
            this.name = name;
            this.image = image;
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
//
//        public int getCategoryId() {return categoryId;}
//        public void setCategoryId(int categoryId) {this.categoryId = categoryId;}

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getImage() {return image;}
        public void setImage(String image) {this.image = image;}

        public String getDescription() {return description;}
        public void setDescription(String description) {this.description = description;}

        public int getQuantity() {return quantity;}
        public void setQuantity(int quantity) {this.quantity = quantity;}

        public double getPrice() {return price;}
        public void setPrice(double price) {this.price = price;}

//        @Override
//        public String toString() {
//            return "Food [id=" + id + ", categoryId=" + categoryId + ", name=" + name +
//                    ", image=" + image + ", description=" + description +
//                    ", quantity=" + quantity + ", price=" + price + "]";
//        }

        @Override
        public String toString() {
            return "Food [id=" + id + ",  name=" + name +
                    ", image=" + image + ", description=" + description +
                    ", quantity=" + quantity + ", price=" + price + "]";
        }

    }