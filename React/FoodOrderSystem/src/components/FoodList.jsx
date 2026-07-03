import React, { useEffect, useState } from "react";
import { Card, Button } from "react-bootstrap";
import "../components/FoodList.css";

const addToCart = (foodItem) => {
  const cartItem = {
    userEmail: "test@gmail.com",
    foodId: foodItem.id,
    foodName: foodItem.name,
    price: foodItem.price,
    quantity: 1,
    imageUrl: foodItem.imageUrl // ✅ important
  };

  fetch("http://localhost:8080/cart/add", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(cartItem),
  })
    .then((res) => res.json())
    .then(() => alert("Added To Cart ✅"))
    .catch((err) => console.error(err));
};

const FoodList = () => {
  const [food, setFoods] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/foods")
      .then((res) => res.json())
      .then((data) => setFoods(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4 fw-bold">Explore Food 🍔</h2>

      <div className="row">
        {food.map((f) => (
          <div className="col-md-4 col-sm-6 mb-4" key={f.id}>
            <Card className="h-100 shadow-sm border-0 rounded-4 food-card">
              <Card.Img
                src={f.imageUrl}
                style={{ height: "220px", objectFit: "cover" }}
              />

              <Card.Body className="text-center">
                <h5 className="fw-bold">{f.name}</h5>

                <p className="text-success fw-bold fs-5">{f.price} ₹</p>

                <div className="d-flex justify-content-center gap-2">
                  <Button variant="primary" onClick={() => addToCart(f)}>
                    Add
                  </Button>
                  <Button variant="success">Order</Button>
                </div>
              </Card.Body>
            </Card>
          </div>
        ))}
      </div>
    </div>
  );
};

export default FoodList;