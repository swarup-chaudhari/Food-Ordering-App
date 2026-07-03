import React, { useEffect, useState } from "react";
import { Button, Card } from "react-bootstrap";

const Cart = () => {
  const [cart, setCart] = useState([]);
  const email = "test@gmail.com";

  const fetchCart = () => {
    fetch(`http://localhost:8080/cart/${email}`)
      .then((res) => res.json())
      .then((data) => setCart(data))
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    fetchCart();
  }, []);

  const removeItem = (id) => {
    fetch(`http://localhost:8080/cart/item/${id}`, {
      method: "DELETE",
    }).then(() => {
      alert("Item Removed ❌");
      fetchCart();
    });
  };

  const total = cart.reduce(
    (sum, item) => sum + item.price * item.quantity,
    0
  );

  const placeOrder = () => {
    fetch(`http://localhost:8080/order/place/${email}`, {
      method: "POST",
    })
      .then((res) => res.json())
      .then(() => {
        alert("Order Placed ✅");
        fetchCart();
      });
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center fw-bold mb-4">Your Cart 🛒</h2>

      {cart.length === 0 ? (
        <h4 className="text-center text-muted">No Items</h4>
      ) : (
        <>
          <div className="row">
            {cart.map((item) => (
              <div className="col-md-4 mb-4" key={item.id}>
                <Card className="shadow border-0 rounded-4 p-3 text-center">
                  <img
                    src={item.imageUrl}
                    alt={item.foodName}
                    style={{ height: "120px", objectFit: "cover" }}
                    className="rounded mb-2"
                  />

                  <h5>{item.foodName}</h5>
                  <p>{item.price} ₹</p>
                  <p>Qty: {item.quantity}</p>

                  <Button
                    variant="outline-danger"
                    onClick={() => removeItem(item.id)}
                  >
                    Remove
                  </Button>
                </Card>
              </div>
            ))}
          </div>

          <div className="text-center mt-4">
            <h3>Total: {total} ₹</h3>

            <Button className="mt-2 px-4" onClick={placeOrder}>
              Place Order
            </Button>
          </div>
        </>
      )}
    </div>
  );
};

export default Cart;